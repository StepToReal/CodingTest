package com.code.codingtest.skillcheck.level0;

import java.util.*;

public class AdditionOfFraction {
    public static void main(String[] args) {
        int denum1 = 1;
        int num1 = 2;
        int denum2 = 3;
        int num2 = 4;

        System.out.println(Arrays.toString(new AdditionOfFraction().solution(denum1, num1, denum2, num2)));
    }

    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int denum = (denum1 * num2) + (denum2 * num1); // 분자
        int num = num1 * num2; //분모

        int maxCommonDivisionNum = getMaxCommonDivisionNum(denum, num);

        return new int[]{denum / maxCommonDivisionNum, num / maxCommonDivisionNum};
    }

    private int getMaxCommonDivisionNum(int denum, int num) {
        List<Integer> denumList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        denumList.add(denum);
        numList.add(num);

        for (int i = 2; i <= denum / 2; i++) {
            if (denum % i == 0) {
                denumList.add(i);
            }
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                numList.add(i);
            }
        }

        denumList.sort(Comparator.reverseOrder());

        for (Integer denum1 : denumList) {
            if (numList.contains(denum1)) {
                return denum1;
            }
        }

        return 1;
    }
}
