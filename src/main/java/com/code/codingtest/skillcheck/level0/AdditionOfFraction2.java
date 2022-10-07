package com.code.codingtest.skillcheck.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AdditionOfFraction2 {
    public static void main(String[] args) {
        int denum1 = 1;
        int num1 = 2;
        int denum2 = 3;
        int num2 = 4;

        System.out.println(Arrays.toString(new AdditionOfFraction2().solution(denum1, num1, denum2, num2)));
    }

    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer;

        denum1 *= num2;
        denum2 *= num1;

        answer = new int[]{denum1 + denum2, num1 * num2};

        int greatestCommonDivisor = getCommonDivisor(answer[0], answer[1]);
        answer[0] /= greatestCommonDivisor;
        answer[1] /= greatestCommonDivisor;

        return answer;
    }

    private int getCommonDivisor(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getCommonDivisor(num2, num1 % num2);
    }
}
