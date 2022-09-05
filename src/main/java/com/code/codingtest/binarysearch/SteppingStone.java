package com.code.codingtest.binarysearch;

import java.util.Arrays;

public class SteppingStone {
    public static void main(String[] args) {
        int distance = 25;
//        int[] rocks = {2,14,11,21,17};
        int[] rocks = {2,11,14,17,21};
        int n = 2; //4

        System.out.println(new SteppingStone().solution(distance, rocks, n));
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        long left = 0, right = distance;
        Arrays.sort(rocks);

        while (left <= right) {
            int mid = (int)((left + right) / 2);
            int removeRockCount = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    removeRockCount++;
                } else {
                    prev = rocks[i];
                }
            }

            if (distance - rocks[rocks.length - 1] < mid) {
                removeRockCount++;
            }

            if (removeRockCount <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
