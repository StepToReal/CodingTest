package com.code.codingtest.skillcheck.level0;

public class SafeZone {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};

        System.out.println(new SafeZone().solution(board));
    }

    public int solution(int[][] board) {
        int answer = 0;
        int[][] warningArea = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < warningArea.length; k++) {
                        int x = i + warningArea[k][0];
                        int y = j + warningArea[k][1];

                        if (x < 0) x = 0;
                        else if (x > board.length - 1) x = board.length - 1;

                        if (y < 0) y = 0;
                        else if (y > board[0].length - 1) y = board[0].length - 1;

                        if (board[x][y] != 1)
                            board[x][y] = 2;
                    }
                }
            }
        }

        for (int[] b : board) {
            for (int temp : b) {
                if (temp == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
