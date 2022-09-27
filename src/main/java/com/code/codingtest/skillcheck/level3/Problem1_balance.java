package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class Problem1_balance {
    public static void main(String[] args) {
        int n = 9;
        int[] money = {1, 2, 3, 4, 5};

        System.out.println(new Problem1_balance().solution(n, money));
    }

    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m = 0; m < money.length; m++) {
            for (int i = 1; i <= n; i++) {
                if (money[m] <= i) {
                    dp[i] += (dp[i - money[m]] % 1_000_000_007);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
