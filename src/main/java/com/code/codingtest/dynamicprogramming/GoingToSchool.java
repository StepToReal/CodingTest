package com.code.codingtest.dynamicprogramming;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.ArrayList;
import java.util.List;

public class GoingToSchool {
    public static void main(String[] args) {
        int width = 7;
        int height = 4;
        int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};

        System.out.println(new GoingToSchool().solution(width, height, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        int modValue = 1000000007;
        int[][] map = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    map[i][j] = 1;
                } else if (i == 0) {
                    map[i][j] = map[i][j - 1] % modValue;
                } else if (j == 0) {
                    map[i][j] = map[i - 1][j] % modValue;
                } else {
                    map[i][j] = map[i - 1][j] % modValue + map[i][j - 1] % modValue;
                }
            }
        }

        return map[n - 1][m - 1] % modValue;
    }
}
