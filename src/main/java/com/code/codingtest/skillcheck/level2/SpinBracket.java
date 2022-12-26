package com.code.codingtest.skillcheck.level2;

import java.util.Stack;

public class SpinBracket {
    public static void main(String[] args) {
        System.out.println(new SpinBracket().solution("}]()[{"));
    }

    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char firstChar = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(firstChar);

            String temp = sb.toString();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if (!stack.isEmpty() && isMatchBracket(stack.peek(), temp.charAt(j))) {
                    stack.pop();
                } else {
                    stack.push(temp.charAt(j));
                }
            }

            if (stack.isEmpty()) answer++;
        }

        return answer;
    }

    private boolean isMatchBracket(Character c1, Character c2) {
        String s = new String(new char[]{c1, c2});
        return s.equals("()") || s.equals("{}") || s.equals("[]");
    }
}
