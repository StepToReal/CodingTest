package com.code.codingtest.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskControllerImprove1 {

    public static void main(String[] args) {
        int[][] jobs = {{1,2}, {1,3}, {2,2}, {12,1}, {12,2}, {14,1}, {14,7}};

        System.out.println(new DiskControllerImprove1().solution(jobs));
    }

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] <= o2[0]) {
                    return -1;
                }
                return 1;
            }            
        });

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
                return 1;
            }            
        });

        int time = 0;
        int index = 0;
        int answer = 0;

        while (true) {
            while (index < jobs.length && jobs[index][0] <= time) {
                queue.offer(jobs[index]);
                index++;
            }

            if (queue.size() == 0) {
                time = jobs[index][0];
                continue;
            }

            int[] job = queue.poll();

            System.out.println(Arrays.toString(job));

            time += job[1];
            answer += time - job[0];
            
            if (index == jobs.length && queue.size() == 0) {
                break;
            }
        }

        answer /= jobs.length;
        return answer;
    }
}