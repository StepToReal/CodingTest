package com.code.codingtest.skillcheck.level0;

import java.util.Arrays;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        int num = 5;
        int total = 5;

        System.out.println(Arrays.toString(new ConsecutiveNumbersSum().solution(num, total)));
    }

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int criterionNumber = total / num;
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum += criterionNumber + i;
        }

        criterionNumber += (total - sum) / num;

        for (int i = 0; i < num; i++) {
            answer[i] = criterionNumber + i;
        }

        return answer;
    }
}
