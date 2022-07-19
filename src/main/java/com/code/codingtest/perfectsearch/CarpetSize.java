package com.code.codingtest.perfectsearch;

import java.util.Arrays;

public class CarpetSize {
    public static void main(String[] args) {
        int[] result = new CarpetSize().solution(10, 2);

        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int height = 0;

        for (int i = 1; i <= (yellow / 2) + 1; i++) {
            if (yellow % i == 0) {
                width = i + 2;
                height = (yellow / i) + 2;

                if (total == width * height) {
                    break;
                }
            }
        }

        return new int[] {Math.max(width, height), Math.min(width, height)};
    }
}
