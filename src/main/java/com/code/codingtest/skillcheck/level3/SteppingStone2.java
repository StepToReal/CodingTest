package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class SteppingStone2 {
    public static void main(String[] args) {
//        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int k = 3;

        int[] stones = {5,4,9,10,8,3,2};
        int k = 2;

//        int[] stones = {5,5,5,5};
//        int k = 2;

        System.out.println(new SteppingStone2().solution(stones, k));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = 0;
        int max = Arrays.stream(stones).max().getAsInt();

        while (min <= max) {
            int mid = (min + max) / 2;

            if (isCross(mid, stones, k)) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean isCross(int mid, int[] stones, int k) {
        int zeroCount = 0;

        for (int stone : stones) {
            stone -= mid;
            if (stone < 0) {
                zeroCount++;
            } else {
                zeroCount = 0;
            }

            if (zeroCount >= k) {
                return false;
            }
        }

        return true;
    }
}
