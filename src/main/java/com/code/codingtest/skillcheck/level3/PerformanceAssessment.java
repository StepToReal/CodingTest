package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class PerformanceAssessment {
    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};

        //3,2  3,2  2,1  2,2  1,4
        System.out.println(new PerformanceAssessment().solution(scores));
    }

    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int maxValue = 0;

        for (int[] score : scores) {
            if (score[1] < maxValue) {
                if (score[0] == wanho[0] && score[1] == wanho[1]) return -1;
            } else {
                maxValue = score[1];

                if (score[0] + score[1] > wanho[0] + wanho[1]) {
                    answer++;
                }
            }
        }

        return answer + 1;
    }
}
