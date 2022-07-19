package com.code.codingtest.perfectsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        /*
            1번 수포자 - 1,2,3,4,5, 1,2,3,4,5
            2번 수포자 - 2,1,2,3,2,4,2,5, 2,1,2,3,2,4,2,5
            3번 수포자 - 3,3,1,1,2,2,4,4,5,5, 3,3,1,1,2,2,4,4,5,5
        */
        int[] answers = {1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4};

        System.out.println(Arrays.toString(new MockExam().solution(answers)));

    }

    public int[] solution (int[] answers) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();

        int[] oneAnswer = {1,2,3,4,5};
        int[] twoAnswer = {2,1,2,3,2,4,2,5};
        int[] treeAnswer = {3,3,1,1,2,2,4,4,5,5};

        int oneCnt = 0;
        int twoCnt = 0;
        int treeCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            int oneIndex = i % oneAnswer.length;
            int twoIndex = i % twoAnswer.length;
            int treeIndex = i % treeAnswer.length;

            if (answers[i] == oneAnswer[oneIndex]) oneCnt++;
            if (answers[i] == twoAnswer[twoIndex]) twoCnt++;
            if (answers[i] == treeAnswer[treeIndex]) treeCnt++;
        }

        int[] cntArr = new int[3];
        cntArr[0] = oneCnt;
        cntArr[1] = twoCnt;
        cntArr[2] = treeCnt;

        Arrays.sort(cntArr);

        int max = cntArr[2];

        if (oneCnt == max) answerList.add(1);
        if (twoCnt == max) answerList.add(2);
        if (treeCnt == max) answerList.add(3);

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
