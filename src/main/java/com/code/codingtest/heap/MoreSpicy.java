package com.code.codingtest.heap;

import java.util.PriorityQueue;

public class MoreSpicy {
    
    public static void main(String[] args) {
        
        /*
        식 = 가장 낮은 값 + (두번째 낮은값  * 2)
        1번 섞음 = 1 + 2 * 2 = 5 --> [5,3,9,10,12]
        2번 섞음 = 3 + 5 * 2 = 13 --> [13, 9, 10, 12]
        return 2
        */

        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        int result = new MoreSpicy().solution(scoville, K);

        System.out.println(result);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int scovilleItem : scoville) {
            priorityQueue.offer(scovilleItem);
        }

        while (priorityQueue.size() > 1 && priorityQueue.peek() < K) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int mix = first + second * 2;

            priorityQueue.offer(mix);

            answer++;
        }

        if (priorityQueue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
