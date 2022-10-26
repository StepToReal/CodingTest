package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;

public class BinaryConvertLoop {
    public static void main(String[] args) {
        String s = "1111111";

        System.out.println(Arrays.toString(new BinaryConvertLoop().solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = new int[2]; //{ 회차, 0제거 개수 }

        while (!s.equals("1")) {
            int prevLength = s.length();

            s = s.replaceAll("0", "");
            answer[1] += prevLength - s.length();

            s = Integer.toBinaryString(s.length());

            answer[0]++;
        }

        return answer;
    }
}
