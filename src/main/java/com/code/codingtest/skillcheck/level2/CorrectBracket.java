package com.code.codingtest.skillcheck.level2;

public class CorrectBracket {
    public static void main(String[] args) {

    }

    public boolean solution (String s) {

        if (!s.startsWith("(") || !s.endsWith(")")) {
            return false;
        } else if (s.length() % 2 != 0) {
            return false;
        }else {
            int num = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    num++;
                } else {
                    num--;
                }

                if (num < 0) {
                    return false;
                }
            }

            return num == 0;
        }
    }
}
