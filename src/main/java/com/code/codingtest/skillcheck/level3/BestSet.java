package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        int n = 6;
        int s = 125;

        System.out.println(Arrays.toString(new BestSet().solution(n, s)));
    }

    public int[] solution(int n, int s) {
        int[] answer = {};

        if (s < n) {
            return new int[] {-1};
        }

        answer = new int[n];

        int value = s / n;
        int other = s % n;

        for (int i = 0; i < answer.length; i++) {
            if (i >= n - other) {
                answer[i] = value + 1;
            } else {
                answer[i] = value;
            }
        }

        return answer;
    }
}
