package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

public class NightWorkPoint2 {
    public static void main(String[] args) {
        int[] works = {4,3,3};
        int n = 4;

        System.out.println(new NightWorkPoint2().solution(n, works));
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        int[] result = new int[works.length];
        int totalOvertime = Arrays.stream(works).sum() - n;
        int time = totalOvertime;

        if (time <= 0) return 0;

        for (int i = 0; i < works.length; i++) {
            result[i] = Math.min(works[i], totalOvertime / works.length);
            time -= result[i];
        }

        for (int i = 0; i < works.length; i++) {
            if (time <= 0) break;
            if (works[i] > result[i]) {
                result[i]++;
                time--;
            }

            if (i == works.length - 1) i = -1;
        }

        for (int i : result) {
            answer += Math.pow(i, 2);
        }

        return answer;
    }
}
