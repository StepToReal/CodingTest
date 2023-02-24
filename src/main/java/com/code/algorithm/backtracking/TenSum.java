package com.code.algorithm.backtracking;

public class TenSum {
    public static void main(String[] args) {
        int sum = getSum(10);
        System.out.println(sum);
    }

    private static int getSum(int n) {
        if (n == 0) {
            return 0;
        }

        return n + getSum(n - 1);
    }
}
