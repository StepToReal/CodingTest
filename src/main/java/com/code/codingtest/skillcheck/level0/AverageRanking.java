package com.code.codingtest.skillcheck.level0;

import java.util.*;

public class AverageRanking {
    public static void main(String[] args) {
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};

        System.out.println(Arrays.toString(new AverageRanking().solution(score)));
    }

    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] averages = new double[score.length];
        Set<Double> averageSet = new TreeSet<>((d1, d2) -> Double.compare(d2, d1));

        for (int i = 0; i < score.length; i++) {
            double average = (double)(score[i][0] + score[i][1]) / 2;
            averages[i] = average;
            averageSet.add(average);
        }

        int ranking = 1;

        for (Double avg : averageSet) {
            int rank = ranking;
            for (int i = 0; i < score.length; i++) {
                if (averages[i] == avg) {
                    answer[i] = rank;
                    ranking++;
                }
            }
        }

        return answer;
    }

    public int[] solution2(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();

        for (int[] s : score) {
            scoreList.add(s[0] + s[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
        }

        return answer;
    }
}
