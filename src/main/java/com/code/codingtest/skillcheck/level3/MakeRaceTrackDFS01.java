package com.code.codingtest.skillcheck.level3;

import java.util.*;

//카카오 - 경주로 건설
public class MakeRaceTrackDFS01 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};

        int[][] board2 = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        int[][] board3 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        int[][] board4 = {{0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(new MakeRaceTrackDFS01().solution(board4));
    }

    int length = 0;
    int[][][] costs;
    int[][] board;
    final int MAX = 1000000000;
    final int ROW = 0;
    final int COLUMN = 1;

    public int solution(int[][] board) {
        this.board = board;
        length = board.length;
        costs = new int[length][length][2];

        for (int[][] costs2 : costs) {
            for (int[] costs3 : costs2) {
                Arrays.fill(costs3, MAX);
            }
        }

        costs[0][0][0] = 0;
        costs[0][0][1] = 0;

        if (board[0][1] != 1)
            search(0, 1, 100, ROW);
        if (board[1][0] != 1) {
            search(1, 0, 100, COLUMN);
        }

        return Math.min(costs[length - 1][length - 1][ROW], costs[length - 1][length - 1][COLUMN]);
    }

    private void search(int i, int j, int cost, int dir) {
        costs[i][j][dir] = cost;

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                int a = costs[x][y][0] == MAX ? 0 : costs[x][y][0];
                int b = costs[x][y][1] == MAX ? 0 : costs[x][y][1];
                System.out.printf("%15s", a + ", " + b);
            }
            System.out.println();
        }
        System.out.println();

        //하
        if (i != this.length - 1 && board[i + 1][j] != 1) {
            if (dir == COLUMN && this.costs[i + 1][j][COLUMN] >= cost + 100)
                search(i + 1, j, cost + 100, COLUMN);
            else if (dir == ROW && this.costs[i + 1][j][COLUMN] >= cost + 600)
                search(i + 1, j, cost + 600, COLUMN);
        }
        //우
        if (j != this.length - 1 && board[i][j + 1] != 1) {
            if (dir == ROW && this.costs[i][j + 1][ROW] >= cost + 100)
                search(i, j + 1, cost + 100, ROW);
            else if (dir == COLUMN && this.costs[i][j + 1][ROW] >= cost + 600)
                search(i, j + 1, cost + 600, ROW);
        }
        //상
        if (i != 0 && board[i - 1][j] != 1) {
            if (dir == COLUMN && this.costs[i - 1][j][COLUMN] >= cost + 100)
                search(i - 1, j, cost + 100, COLUMN);
            else if (dir == ROW && this.costs[i - 1][j][COLUMN] >= cost + 600)
                search(i - 1, j, cost + 600, COLUMN);
        }
        //좌
        if (j != 0 && board[i][j - 1] != 1) {
            if (dir == ROW && this.costs[i][j - 1][ROW] >= cost + 100)
                search(i, j - 1, cost + 100, ROW);
            else if (dir == COLUMN && this.costs[i][j - 1][ROW] >= cost + 600)
                search(i, j - 1, cost + 600, ROW);
        }
    }
}