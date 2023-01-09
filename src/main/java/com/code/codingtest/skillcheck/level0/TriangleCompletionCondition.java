package com.code.codingtest.skillcheck.level0;

public class TriangleCompletionCondition {
    public static void main(String[] args) {

    }

    public int solution(int[] sides) {
        int answer = 0;
        int min = Math.min(sides[0], sides[1]);

        answer = min + min - 1;

        return answer;
    }
}
