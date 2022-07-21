package com.code.codingtest.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class NExpressImprove {
    public static void main(String[] args) {
        int n = 5;
        int number = 12;

        System.out.println(new NExpress().solution(n, number));
    }

    public int solution(int n, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = n;

        for (int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + n;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer a : setArr[j]) {
                    for (Integer b : setArr[i - j]) {
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if (b != 0) setArr[i].add(a / b);
                        if (a != 0) setArr[i].add(b / a);
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            if (setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
