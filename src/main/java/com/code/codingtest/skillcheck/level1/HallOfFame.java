package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HallOfFame {
    public static void main(String[] args) {
        int k = 3;
        int[] socre = {10, 100, 20, 150, 1, 100, 200};

        System.out.println(Arrays.toString(new HallOfFame().solution(k, socre)));
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int i = 0;
        for (int s : score) {
            queue.add(s);

            if (queue.size() > k) {
                queue.poll();
            }

            answer[i++] = queue.peek();
        }

        return answer;
    }
}
