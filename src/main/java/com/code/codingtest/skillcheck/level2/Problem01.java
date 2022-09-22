package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class Problem01 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new Problem01().solution(progresses, speeds)));
    }

    private int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int[] answer;
        int[] periods = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                periods[i] = (100 - progresses[i]) / speeds[i];
            } else {
                periods[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
        }

        for (int i = 0; i < periods.length; i++) {
            int deployCount = 1;

            if (i == periods.length - 1) {
                answerList.add(deployCount);
            }

            for (int j = i + 1; j < periods.length; j++){
                if (periods[i] >= periods[j]) {
                    deployCount++;

                    if (j == periods.length - 1) {
                        answerList.add(deployCount);
                        i = j;
                    }
                } else {
                    answerList.add(deployCount);
                    i = j - 1;
                    break;
                }
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
