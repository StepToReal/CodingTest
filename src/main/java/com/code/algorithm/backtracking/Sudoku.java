package com.code.algorithm.backtracking;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sudoku {

    static int[][] board;
    static List<Point> emptyList = new ArrayList<>();
    static int n = 9;

    public static void main(String[] args) throws IOException {
        board = new int[n][n];
        int inputCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (inputCount < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                board[inputCount][i] = value;

                if (value == 0) {
                    Point p = new Point(inputCount, i);
                    emptyList.add(p);
                }
            }

            inputCount++;
        }

        sudoku(0);
    }

    private static void sudoku(int emptyIndex) {
        if (emptyIndex >= emptyList.size()) {
            printBoard();
            System.exit(0);
        }

        Point p = emptyList.get(emptyIndex);

        if (board[p.x][p.y] != 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isValidate(p, i)) {
                board[p.x][p.y] = i;
                sudoku(emptyIndex + 1);
                board[p.x][p.y] = 0;
            }
        }
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();

        for (int[] b : board) {
            for (int value : b) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean isValidate(Point p, int num) {
        int x = p.x;
        int y = p.y;

        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for (int i = 0; i < n; i++) {
            if (board[x][i] == num) return false;
            if (board[i][y] == num) return false;
        }

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}