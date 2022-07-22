package com.code.codingtest.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NExpressImproveMySelf {
    public static void main(String[] args) {
        int n = 5;
        int number = 12;

        System.out.println(new NExpressImproveMySelf().solution(n, number));
    }

    public int solution(int n, int number) {
        Set<Integer>[] setArray = new Set[9];
        int continuousNumber = 0;

        for (int i = 1; i < setArray.length; i++) {
            continuousNumber += n * Math.pow(10, i - 1);
            setArray[i] = new HashSet<>();
            setArray[i].add(continuousNumber);
        }

        for (int i = 1; i < setArray.length; i++) {
            for (int j = 1; j < i; j++) {
                if (i-j >= j) {
                    setArray[i].addAll(getNoSet(setArray[i - j], setArray[j]));
                }
            }

            if (setArray[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    private Set<Integer> getNoSet(Set<Integer> no1, Set<Integer> no2) {
        Set<Integer> result = new HashSet<>();

        for (int n1 : no1) {
            for (int n2 : no2) {
                result.add(n1 + n2);
                result.add(n1 - n2);
                result.add(n2 - n1);
                result.add(n1 * n2);
                if (n2 > 0) { result.add(n1 / n2); }
                if (n1 > 0) { result.add(n2 / n1); }
            }
        }

        return result;
    }
}
