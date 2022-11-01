package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class CollectingStickers {
    public static void main(String[] args) {
//        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
//        int[] sticker = {1,3,2,5,4};
        int[] sticker = {99, 60, 1, 51, 100, 51};

        System.out.println(new CollectingStickers().solution(sticker));
    }

    public int solution(int sticker[]) {

        if (sticker.length == 1) {
            return sticker[0];
        }

        int[] dp0 = new int[sticker.length];
        int[] dp1 = new int[sticker.length];

        dp0[0] = sticker[0];
        dp0[1] = sticker[0];

        dp1[1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            dp0[i] = Math.max(dp0[i - 1], sticker[i] + dp0[i - 2]);
            dp1[i] = Math.max(dp1[i - 1], sticker[i] + dp1[i - 2]);
        }

        return Math.max(dp0[sticker.length - 2], dp1[sticker.length - 1]);
    }
}
