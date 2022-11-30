package com.code.codingtest.skillcheck.level0;

import java.util.*;

public class UnusualSort {
    public static void main(String[] args) {
        int[] numlist = {1, 2, 3, 4, 5, 6};
        int n = 4;

        System.out.println(Arrays.toString(new UnusualSort().solution(numlist, n)));
    }

    public int[] solution(int[] numlist, int n) {
        List<int[]> list = new ArrayList<>();

        for (int num : numlist) {
            int[] arr = {Math.abs(num - n), num};
            list.add(arr);
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] answer = new int[numlist.length];

        int i = 0;

        for (int[] l : list) {
            answer[i++] = l[1];
        }

        return answer;
    }
}
