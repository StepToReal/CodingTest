package com.code.codingtest.dynamicprogramming;

import java.util.*;

public class NExpress {
    public static void main(String[] args) {
        int n = 5;
        int number = 12;

        System.out.println(new NExpress().solution(n, number));
    }

    public int solution(int n, int number) {
        Set<Integer> no1 = new HashSet<>(Arrays.asList(n));
        Set<Integer> no2 = new HashSet<>(Arrays.asList(n+n, n-n, n*n, n/n, Integer.parseInt(String.valueOf(n) + String.valueOf(n))));

        if (no1.contains(number)) return 1;
        else if (no2.contains(number)) return 2;

        Set<Integer> no3 = new HashSet<>();
        no3.add(getJoinNum(3, n));
        no3.addAll(getNoSet(no1, no2));
        if (no3.contains(number)) return 3;

        Set<Integer> no4 = new HashSet<>();
        no4.add(getJoinNum(4, n));
        no4.addAll(getNoSet(no1, no3));
        no4.addAll(getNoSet(no2, no2));
        if (no4.contains(number)) return 4;

        Set<Integer> no5 = new HashSet<>();
        no5.add(getJoinNum(5, n));
        no5.addAll(getNoSet(no1, no4));
        no5.addAll(getNoSet(no2, no3));
        if (no5.contains(number)) return 5;

        Set<Integer> no6 = new HashSet<>();
        no6.add(getJoinNum(6, n));
        no6.addAll(getNoSet(no1, no5));
        no6.addAll(getNoSet(no2, no4));
        no6.addAll(getNoSet(no3, no3));
        if (no6.contains(number)) return 6;

        Set<Integer> no7 = new HashSet<>();
        no7.add(getJoinNum(7, n));
        no7.addAll(getNoSet(no1, no6));
        no7.addAll(getNoSet(no2, no5));
        no7.addAll(getNoSet(no3, no4));
        if (no7.contains(number)) return 7;

        Set<Integer> no8 = new HashSet<>();
        no8.add(getJoinNum(8, n));
        no8.addAll(getNoSet(no1, no7));
        no8.addAll(getNoSet(no2, no6));
        no8.addAll(getNoSet(no3, no5));
        no8.addAll(getNoSet(no4, no4));
        if (no8. contains(number)) return 8;

        return -1;
    }

    private Integer getJoinNum(int count, int n) {
        int result = 0;

        for (int i = 0; i < count; i++) {
            result += Math.pow(10, i) * n;
        }

        return result;
    }

    private Set<Integer> getNoSet(Set<Integer> no1, Set<Integer> no2) {
        Set<Integer> result = new HashSet<>();

        for (int n1 : no1) {
            for (int n2 : no2) {
                result.add(n1 + n2);
                result.add(n1 - n2);
                result.add(n2 - n1);
                result.add(n1 * n2);
                if (n2 > 0) {
                    result.add(n1 / n2);
                }
                if (n1 > 0) {
                    result.add(n2 / n1);
                }
            }
        }

        return result;
    }
}
