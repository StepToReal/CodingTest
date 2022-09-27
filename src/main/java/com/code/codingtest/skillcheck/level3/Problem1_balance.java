package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class Problem1_balance {
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 3, 4, 5};

        System.out.println(new Problem1_balance().solution(n, money));
    }
    int answer = 0;

    public int solution(int n, int[] money) {
        Arrays.sort(money);

        int[] count = new int[money.length];

        for (int i = 0; i < money.length; i++) {
            count[i] = n / money[i];
        }

        for (int i = 0; i < money.length; i++) {
            dfs(n, i, money, count);
        }

        return answer % 1_000_000_007;
    }

    private void dfs(int n, int moneyType, int[] money, int[] count) {
        for (int index = 1; index <= count[moneyType]; index++) {
            int m = n - money[moneyType] * index;

            if (m > 0) {
                for (int i = moneyType + 1; i < money.length; i++) {
                    dfs(m, i, money, count);
                }
            } else if (m == 0) {
                answer = answer % 1_000_000_007 + 1;
                break;
            } else {
                break;
            }
        }
    }
}
