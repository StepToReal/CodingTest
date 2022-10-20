package com.code.codingtest.skillcheck.level2;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(new FibonacciNumber().solution(n));
    }

    public int solution(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 2] % 1234567 + nums[i - 1] % 1234567;
        }

        return nums[n] % 1234567;
    }

    private int getFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return getFibonacci(n - 1) % 1234567 + getFibonacci(n - 2) % 1234567;
    }

}
