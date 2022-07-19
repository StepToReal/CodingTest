package com.code.codingtest.greedy;

import java.util.Stack;

public class BigNumberImprove {
    public static void main(String[] args) {
        String number = "67429495152"; 
        int k = 3;

        System.out.println(new BigNumber().solution(number, k));
    }
    
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }

            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }    
}
