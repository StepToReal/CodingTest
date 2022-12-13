package com.code.codingtest.skillcheck.level1;

public class SplitString {
    public static void main(String[] args) {
        String s = "aaabbaccccabba";

        System.out.println(new SplitString().solution(s));
    }

    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);

        int firstNum = 0;
        int otherNum = 0;

        boolean isWhile = true;
        while (isWhile) {
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1) {
                    answer++;
                    isWhile = false;
                    break;
                }

                if (first == s.charAt(i)) {
                    firstNum++;
                } else {
                    otherNum++;
                }

                if (firstNum == otherNum) {
                    answer++;
                    s = s.substring(i + 1);
                    first = s.charAt(0);
                    break;
                }
            }
        }

        return answer;
    }

    public int solution2(String s) {
        int answer = 0;
        char prev = '1';
        int same = 0;
        int different = 0;

        for (char c : s.toCharArray()) {
            if (prev == '1') {
                prev = c;
                same++;
                answer++;
            } else if (prev == c) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                prev = '1';
                same = 0;
                different = 0;
            }
        }

        return answer;
    }
}
