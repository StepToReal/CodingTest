package com.code.codingtest.skillcheck.level3;

public class ContinuousPulseSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(new ContinuousPulseSum().solution(arr));
    }

    public long solution(int[] sequence) {
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                dp1[i] = sequence[i];
                dp2[i] = sequence[i] * -1;
            } else {
                dp1[i] = sequence[i] * -1;
                dp2[i] = sequence[i];
            }
        }

        long max1 = dp1[0];
        long max2 = dp2[0];

        for (int i = 1; i < sequence.length; i++) {
            dp1[i] = dp1[i] + (dp1[i - 1] <= 0 ? 0 :dp1[i - 1]);
            dp2[i] = dp2[i] + (dp2[i - 1] <= 0 ? 0 :dp2[i - 1]);

            max1 = Math.max(max1, dp1[i]);
            max2 = Math.max(max2, dp2[i]);
        }

        return Math.max(max1, max2);
    }
}
