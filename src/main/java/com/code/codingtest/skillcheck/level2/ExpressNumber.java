package com.code.codingtest.skillcheck.level2;

import com.sun.media.sound.SoftTuning;

public class ExpressNumber {
    public static void main(String[] args) {
        int n = 15;

        System.out.println(new ExpressNumber().solution(n));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int result = 0;

            for (int j = i; j < n; j++) {
                result += j;

                if (result == n) {
                    answer++;
                    break;
                } else if (result > n) {
                    break;
                }
            }
        }

        return ++answer;
    }
}
