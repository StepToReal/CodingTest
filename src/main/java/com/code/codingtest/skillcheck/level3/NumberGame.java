package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class NumberGame {
    public static void main(String[] args) {
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};

        System.out.println(new NumberGame().solution(a, b));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>();

        aQueue.addAll(Arrays.stream(A).boxed().collect(Collectors.toList()));
        bQueue.addAll(Arrays.stream(B).boxed().collect(Collectors.toList()));

        while (!aQueue.isEmpty()) {
            Integer a = aQueue.poll();
            while (!bQueue.isEmpty()) {
                Integer b = bQueue.poll();

                if (a < b) {
                    answer++;
                    break;
                }
            }

            if (bQueue.isEmpty()) {
                break;
            }
        }

        return answer;
    }
}
