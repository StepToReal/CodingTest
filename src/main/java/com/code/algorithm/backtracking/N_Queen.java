package com.code.algorithm.backtracking;

import java.util.Scanner;

public class N_Queen {
    static int n;
    static int[] board;
    static boolean[] isPut;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n + 1];
        isPut = new boolean[n + 1];

        nQueen(1);

        System.out.println(answer);
    }

    private static void nQueen(int row) {
        if (row == n + 1) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isPut[i]) continue;

            isPut[i] = true;
            board[row] = i;
            if (isPossible(row, i)) {
                nQueen(row + 1);
            }
            isPut[i] = false;
        }
    }

    private static boolean isPossible(int row, int column) {
        for (int i = row - 1; i > 0; i--) {
            if (Math.abs(row - i) == Math.abs(column - board[i])){
                return false;
            }
        }

        return true;
    }
}
