package com.code.codingtest.skillcheck.level3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UnbrokenBuilding2 {
    public static void main(String[] args) {
//        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
//        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};

        System.out.println(new UnbrokenBuilding2().solution(board, skill));
    }

    public int solution(int[][] board, int[][] skill) {
        //skill[n][0] = type, type 1 = attack, type2 = heal
        int answer = 0;
        int[][] attackBoard = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            int damage = s[0] == 1 ? s[5] * -1 : s[5];

            attackBoard[s[1]][s[2]] += damage;
            attackBoard[s[1]][s[4] + 1] += -1 * damage;
            attackBoard[s[3] + 1][s[2]] += -1 * damage;
            attackBoard[s[3] + 1][s[4] + 1] += damage;
        }

        for (int i = 0; i < attackBoard.length; i++) {
            for (int j = 1; j < attackBoard[0].length; j++) {
                attackBoard[i][j] += attackBoard[i][j - 1];
            }
        }

        for (int i = 1; i < attackBoard.length; i++) {
            for (int j = 0; j < attackBoard[0].length; j++) {
                attackBoard[i][j] += attackBoard[i-1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + attackBoard[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
