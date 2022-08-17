package com.code.codingtest.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumberSolve3 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int[] numbers2 = {4,1,2,1,1,1};

        int target = 3; //5
        int target2 = 2;

        System.out.println(new TargetNumberSolve3().solution(numbers2, target2));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(numbers[0], 0));
        queue.offer(new Pair(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.index == numbers.length - 1) {
                if (p.cur == target) {
                    answer += 1;
                }
                continue;
            }
            int c1 = p.cur + numbers[p.index + 1];
            int c2 = p.cur - numbers[p.index + 1];

            queue.add(new Pair(c1, p.index + 1));
            queue.add(new Pair(c2, p.index + 1));
        }

        return answer;
    }

    class Pair {
        int cur;
        int index;

        Pair(int cur, int index) {
            this.cur = cur;
            this.index = index;
        }
    }
}
