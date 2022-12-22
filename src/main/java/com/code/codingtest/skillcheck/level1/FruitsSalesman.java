package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FruitsSalesman {
    public static void main(String[] args) {
        int highestScore = 4;
        int count = 3;
        int[] scores = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(new FruitsSalesman().solution(highestScore, count, scores));
    }

    public int solution(int highestScore, int count, int[] scores) {
        int answer = 0;

        if (scores.length < count) {
            return 0;
        }

        Arrays.sort(scores);
        for (int i = scores.length - count; i >= 0; i -= count) {
            answer += scores[i] * count;
        }

        return answer;
    }
}
