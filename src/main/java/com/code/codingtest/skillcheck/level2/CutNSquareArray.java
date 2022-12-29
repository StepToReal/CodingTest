package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;

public class CutNSquareArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CutNSquareArray().solution(4,7,14)));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            long quotient = i / n;
            long remainder = i % n;

            if (quotient >= remainder) {
                answer[(int) (i-left)] = (int) (quotient + 1);
            } else {
                answer[(int) (i-left)] = (int) (remainder + 1);
            }
        }

        return answer;
    }
}
