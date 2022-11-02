package com.code.codingtest.skillcheck.level2;

import java.util.Stack;

public class PairRemove {
    public static void main(String[] args) {
        String s = "baabaa";

        System.out.println(new PairRemove().solution(s));
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {

            if (stack.size() > 0) {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    String removeString = "";

    private boolean isRemove(String s) {
        if (s.length() < 2) return false;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                removeString = s.substring(i - 1, i + 1);
                return true;
            }
        }

        return false;
    }
}
