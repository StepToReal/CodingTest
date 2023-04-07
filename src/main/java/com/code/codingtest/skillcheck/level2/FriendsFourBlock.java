package com.code.codingtest.skillcheck.level2;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class FriendsFourBlock {
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 6;
        int n = 6;

        System.out.println(new FriendsFourBlock().solution(m, n, board));
    }

    public int solution(int m, int n, String[] board) {
        boolean isNext = true;
        String[][] boards = new String[m][n];
        int[][] tempArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            boards[i] = board[i].split("");
        }

        while (isNext) {
            isNext = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (boards[i][j].equals("1")) continue;

                    if (boards[i][j].equals(boards[i][j + 1]) &&
                            boards[i][j].equals(boards[i + 1][j]) &&
                            boards[i + 1][j].equals(boards[i + 1][j + 1])) {
                        isNext = true;

                        tempArr[i][j] = 1;
                        tempArr[i][j + 1] = 1;
                        tempArr[i + 1][j] = 1;
                        tempArr[i + 1][j + 1] = 1;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (tempArr[i][j] == 1) {
                        boards[i][j] = "1";

                        for (int k = i - 1; k >= 0; k--) {
                            if (tempArr[k][j] != 1) {
                                boards[i][j] = boards[k][j];
                                boards[k][j] = "1";
                                tempArr[i][j] = 0;
                                tempArr[k][j] = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return Arrays.stream(tempArr).mapToInt(i -> Arrays.stream(i).sum()).sum();
    }
}
