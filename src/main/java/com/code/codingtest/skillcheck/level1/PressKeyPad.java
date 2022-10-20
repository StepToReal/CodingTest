package com.code.codingtest.skillcheck.level1;

import java.util.Map;

public class PressKeyPad {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(new PressKeyPad().solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        int l = 10;
        int r = 12;

        StringBuffer sb = new StringBuffer();

        for (int number : numbers) {
            if (number == 0) number = 11;

            if (number == 1 || number == 4 || number == 7) {
                l = number;
                sb.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                r = number;
                sb.append("R");
            } else {
                int[] lCoord = getCoord(l);
                int[] rCoord = getCoord(r);
                int[] nCoord = getCoord(number);

                int lLen = Math.abs(lCoord[0] - nCoord[0]) + Math.abs(lCoord[1] - nCoord[1]);
                int rLen = Math.abs(rCoord[0] - nCoord[0]) + Math.abs(rCoord[1] - nCoord[1]);

                if (lLen > rLen) {
                    r = number;
                    sb.append("R");
                } else if (lLen < rLen) {
                    l = number;
                    sb.append("L");
                } else {
                    if (hand.equals("left")) {
                        l = number;
                        sb.append("L");
                    } else {
                        r = number;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }

    private int[] getCoord(int num) {
        int[] result = new int[2];

        if (num % 3 == 0) {
            result[0] = (num / 3) - 1;
            result[1] = 2;
        } else {
            result[0] = num / 3;
            result[1] = (num % 3) - 1;
        }

        return result;
    }
}

