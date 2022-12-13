package com.code.codingtest.skillcheck.level3;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetResult;

public class SharedTaxiFareFloyd {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(new SharedTaxiFareFloyd().solution(n, s, a, b, fares));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] floyd = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) floyd[i][j] = 0;
                else {
                    floyd[i][j] = 100000000;
                }
            }
        }

        for (int[] fare : fares) {
            floyd[fare[0] - 1][fare[1] - 1] = fare[2];
            floyd[fare[1] - 1][fare[0] - 1] = fare[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (floyd[i][j] > floyd[i][k] + floyd[j][k]) {
                        floyd[i][j] = floyd[i][k] + floyd[j][k];
                    }
                }
            }
        }

        int[] aStart = floyd[a - 1];
        int[] bStart = floyd[b - 1];
        int[] sStart = floyd[s - 1];

        for (int i = 0; i < n; i++) {
            if (answer > aStart[i] + bStart[i] + sStart[i]) {
                answer = aStart[i] + bStart[i] + sStart[i];
            }
        }

        return answer;
    }
}
