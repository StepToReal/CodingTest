package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StampingStone2 {
    public static void main(String[] args) {
//        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int k = 3;

        int[] stones = {5,4,9,10,8,3,2};
        int k = 2;

//        int[] stones = {5,5,5,5};
//        int k = 2;

        System.out.println(new StampingStone2().solution(stones, k));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = 0;
        int mid = 0;
        int max = Arrays.stream(stones).max().getAsInt();

        while (min <= max) {
            mid = (min + max) / 2;

            int consecutiveZero = 0;
            int zeroNum = 0;

            for (int stone : stones) {
                stone -= mid;

                if (stone < 0) {
                    zeroNum++;
                } else {
                    zeroNum = 0;
                }

                if (zeroNum > k) {

                }
            }

//            if (isPrevZero) consecutiveZero = Math.max(zeroNum, consecutiveZero);

            if (consecutiveZero == k) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else if (consecutiveZero < k ) {
                min = mid + 1;
            } else { // (consecutiveZero > k )
                max = mid - 1;
            }
        }

        return answer;
    }
}
