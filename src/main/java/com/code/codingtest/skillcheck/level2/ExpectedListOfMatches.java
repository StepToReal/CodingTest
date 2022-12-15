package com.code.codingtest.skillcheck.level2;

public class ExpectedListOfMatches {
    public static void main(String[] args) {
        System.out.println(new ExpectedListOfMatches().solution(8, 4, 5));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        int temp;

        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }

        while (a + 1 != b || !(b % 2 == 0)) {
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;

            answer++;
        }

        return answer + 1;
    }
}
