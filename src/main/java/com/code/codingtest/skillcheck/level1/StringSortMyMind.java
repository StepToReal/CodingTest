package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.Comparator;

public class StringSortMyMind {
    public static void main(String[] args) {

    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            int i = o1.charAt(n) - o2.charAt(n);
            if (i == 0) {
                return o1.compareTo(o2);
            }
            return i;
        });

        return strings;
    }
}
