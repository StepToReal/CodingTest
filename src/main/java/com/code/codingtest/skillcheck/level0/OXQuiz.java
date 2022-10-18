package com.code.codingtest.skillcheck.level0;

import java.util.Arrays;

public class OXQuiz {
    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3"};

        System.out.println(Arrays.toString(new OXQuiz().solution(quiz)));
    }

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String q = quiz[i];
            String[] elements = q.split(" ");
            int first =  Integer.parseInt(elements[0]);
            int second = Integer.parseInt(elements[2]);
            int result = Integer.parseInt(elements[4]);
            int realResult = 0;
            String operator = elements[1];

            if (operator.equals("+")) {
                realResult = first + second;
            } else {
                realResult = first - second;
            }

            if (realResult == result) answer[i] = "O";
            else answer[i] = "X";
        }

        return answer;
    }
}
