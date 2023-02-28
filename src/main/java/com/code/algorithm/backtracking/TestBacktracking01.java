package com.code.algorithm.backtracking;

import java.util.Arrays;

public class TestBacktracking01 {

    static int n = 2;
    static int[] temp = new int[2];

    public static void main(String[] args) {
        bt(0, 0);
    }

    private static void bt(int depth, int sum) {
        if (depth == 2) {
            System.out.println(Arrays.toString(temp));
            return;
        }

        sum++;

        for (int i = 1; i <= 4; i++) {
            temp[depth] = i;
            bt(depth + 1, sum);
        }
    }
}
