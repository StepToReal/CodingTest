package com.code.codingtest.binarysearch;

import java.util.*;

public class Immigration {
    public static void main(String[] args) {
//        int n = 1_000_000_000;
//        int[] times = new int[100_000]; //28
        int n = 10;
        int[] times = {5,4,10};

        System.out.println(new Immigration().solution(n, times));
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = (long) n * times[times.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
