package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LandGame {
    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(new LandGame().solution(land));
    }

    public int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;

                    int sum = land[i - 1][k] + land[i][j];
                    max = Math.max(max, sum);
                }
                land[i][j] = max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }


    int max = 0;
    // 시간초과 발생 이럴줄 알았음.
    public int solution2(int[][] land) {
        bt(land, 0, 0, 0);
        return max;
    }

    private void bt(int[][] land, int col, int row, int sum) {
        if (row == land.length) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < land[0].length; i++) {
            if (row != 0 && i == col) continue;

            bt(land, i, row + 1, sum + land[row][i]);
        }
    }
}
