package com.code.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StartAndLink2 {
    static int n;
    static int minGap = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        team(0, 0);

        System.out.println(minGap);
    }

    private static void team(int at, int depth) {
        if (depth == n / 2) {
            int sumA = 0, sumB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i] && visit[j]) {
                        sumA += map[i][j];
                    } else if (!visit[i] && !visit[j]) {
                        sumB += map[i][j];
                    }
                }
            }

            minGap = Math.min(minGap, Math.abs(sumA - sumB));
            return;
        }

        for (int i = at; i < n; i++) {
            if (depth == 0 && i >= 1) {
                break;
            }

            visit[i] = true;
            team(i + 1, depth + 1);
            visit[i] = false;
        }
    }
}
