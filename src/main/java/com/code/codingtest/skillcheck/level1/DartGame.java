package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;

public class DartGame {
    public static void main(String[] args) {
        System.out.println(new DartGame().solution("1D2S#10S"));
    }

    public int solution(String dartResult) {
        int[] answer = new int[3];

        int index = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                String s = Character.toString(c);

                if (Character.isDigit(dartResult.charAt(i + 1))) {
                    s += dartResult.charAt(++i);
                }
                answer[++index] = Integer.parseInt(s);
            } else {
                switch (c) {
                    case 'D':
                        answer[index] = (int) Math.pow(answer[index], 2);
                        break;
                    case 'T':
                        answer[index] = (int) Math.pow(answer[index], 3);
                        break;
                    case '*':
                        if (index > 0) {
                            answer[index - 1] *= 2;
                        }
                        answer[index] *= 2;
                        break;
                    case '#':
                        answer[index] *= -1;
                        break;
                }
            }
        }

        return Arrays.stream(answer).sum();
    }
}
