package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.List;

public class SteppingStone {
    public static void main(String[] args) {
//        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int k = 3;

        int[] stones = {5,4,9,10,8,3,2};
        int k = 2;

//        int[] stones = {5,5,5,5};
//        int k = 2;

        System.out.println(new SteppingStone().solution(stones, k));
    }

    // 정확성은 모두 통과, 효율성은 통과 못함 개선 필요
    public int solution(int[] stones, int k) {
        int answer = 0;

        boolean isCross = true;

        while (isCross) {
            List<Integer> walkableList = new ArrayList<>();

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] != 0) {
                    walkableList.add(i + 1);
                    stones[i] = stones[i] - 1;
                }
            }

            walkableList.add(0, 0);
            walkableList.add(stones.length + 1);

            for (int i = 1; i < walkableList.size(); i++) {
                int prev = walkableList.get(i - 1);
                int curr = walkableList.get(i);

                if (k < curr - prev) {
                    isCross = false;
                    break;
                }
            }

            if (isCross) answer++;
        }

        return answer;
    }
}
