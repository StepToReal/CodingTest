package com.code.codingtest.skillcheck.level0;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class PushString {
    public static void main(String[] args) {
        System.out.println(new PushString().solution("hello", "ohell"));
    }

    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(A);
        Stack<Character> stack = new Stack<>();

        for (Character c : A.toCharArray()) {
            stack.add(c);
        }

        int cnt = 1;
        while (!stack.isEmpty()) {
            sb.deleteCharAt(A.length() - 1);
            sb.insert(0, stack.pop());

            if (sb.toString().equals(B)) {
                return cnt;
            }

            cnt++;
        }

        return -1;
    }

    public int solution2(String A, String B) {
        return (B + B).indexOf(A);
    }
}
