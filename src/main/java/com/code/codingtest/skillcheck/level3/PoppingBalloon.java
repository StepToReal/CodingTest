package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class PoppingBalloon {
    public static void main(String[] args) {
        int[] a = {-16, 27, 65, -2, -71, -92, -68, -61, -33, 58};

        System.out.println(new PoppingBalloon().solution2(a));
    }

    public int solution(int[] a) {
        int answer;
        int minValue = Integer.MAX_VALUE;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        if (a.length <= 2) {
            return a.length;
        } else {
            answer = 2;
        }

        for (int i = 1; i < a.length - 1; i++) {
            minValue = Math.min(minValue, a[i - 1]);
            leftMin[i] = minValue;
        }

        minValue = Integer.MAX_VALUE;

        for (int i = 1; i < a.length - 1; i++) {
            int index = a.length - i;
            minValue = Math.min(minValue, a[index]);
            rightMin[index - 1] = minValue;
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }

        return answer;
    }

    public int solution2(int[] a) {
        int answer = 2;
        if (a.length < 3) return a.length;
        int left = a[0];
        PriorityQueue<Integer> right = new PriorityQueue<>();
        right.add(a[a.length - 1]);

        for (int i = a.length - 2; i > 0; --i) {
            if (right.peek() > a[i]) {
                right.add(a[i]);
            }
        }

        for (int i = 1; i < a.length - 1; i++) {
            int current = a[i];

            if (right.peek() == current) {
                right.poll();
            }
            if (current < left) {
                left = current;
                answer++;
            } else if (current < right.peek()) {
                answer++;
            }
        }

        return answer;
    }
}
