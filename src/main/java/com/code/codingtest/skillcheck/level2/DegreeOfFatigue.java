package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;

public class DegreeOfFatigue {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(new DegreeOfFatigue().solution(k, dungeons));
    }

    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visit = new boolean[dungeons.length];

        recursiveFind(k, dungeons);

        for (boolean v : visit) {
            if (v) {
                answer++;
            }
        }

        return answer;
    }

    public void recursiveFind(int k, int[][] dungeons) {
        int maximumIndex = -1;
        int maxDungeonCount = 0;

        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i]) continue;

            if (dungeons[i][0] <= k) {
                visit[i] = true;
            } else {
                continue;
            }

            int afterK = k - dungeons[i][1];
            int dungeonCount = 0;

            for (int j = 0; j < dungeons.length; j++) {
                if (visit[j]) continue;

                if (afterK >= dungeons[j][0]) {
                    dungeonCount++;
                }
            }

            if (maxDungeonCount < dungeonCount) {
                maxDungeonCount = dungeonCount;
                maximumIndex = i;
            }

            visit[i] = false;
        }

        if (maximumIndex != -1) {
            visit[maximumIndex] = true;
            k -= dungeons[maximumIndex][1];
            recursiveFind(k, dungeons);
        }
    }
}
