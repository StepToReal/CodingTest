package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;

public class DifferentBitTowUnder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DifferentBitTowUnder().solution(new long[] {2l, 7l})));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        int index = 0;
        for (long num : numbers) {
            String binary = Long.toBinaryString(num);
            int oneCount = binary.length() - Long.toBinaryString(num).lastIndexOf("0") - 1;

            answer[index++] = num + Math.max((long)Math.pow(2, oneCount - 1), 1);
        }

        return answer;
    }
}
