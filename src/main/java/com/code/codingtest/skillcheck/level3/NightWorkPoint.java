package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class NightWorkPoint {
    public static void main(String[] args) {
        int[] works = {4,3,3};
        int n = 4;

        System.out.println(new NightWorkPoint().solution(n, works));
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int max = queue.poll();
            if (max <= 0) break;
            queue.offer(max - 1);
        }

        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }

        return answer;
    }
}
