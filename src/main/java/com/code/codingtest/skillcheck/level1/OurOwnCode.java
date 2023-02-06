package com.code.codingtest.skillcheck.level1;

public class OurOwnCode {
    public static void main(String[] args) {
        System.out.println(new OurOwnCode().solution("z", "abcdefghij", 20));
    }

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            char afterChar = getNextChar(skip, temp, index);

            answer.append(afterChar);
        }

        return answer.toString();
    }

    public char getNextChar(String skip, char origin, int index) {
        for (int i = 0; i < index; i++) {
            origin += 1;

            if (origin > 'z') {
                origin = 'a';
            }

            if (skip.indexOf(origin) > -1) {
                i--;
            }
        }

        return origin;
    }
}
