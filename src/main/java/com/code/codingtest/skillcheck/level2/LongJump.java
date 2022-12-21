package com.code.codingtest.skillcheck.level2;

public class LongJump {
    public static void main(String[] args) {
        System.out.println(new LongJump().solution(6));
    }

    public long solution(int n) {
        int mod = 1234567;
        if (n == 1 || n == 2) return n;

        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] % mod) + (arr[i - 2] % mod);
        }

        return arr[n] % mod;
    }
}
