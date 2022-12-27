package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;

public class LottoHighestLowest {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(new LottoHighestLowest().solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int existMatchCount = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            for (int win : win_nums) {
                if (lotto == win) {
                    existMatchCount++;
                }
            }
        }

        int highest = Math.min(6,7- (existMatchCount + zeroCount));
        int lowest = Math.min(6, 7 - existMatchCount);

        return new int[]{highest, lowest};
    }
}
