package com.code.codingtest.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ranking02 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(new Ranking02().solution(n, results));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] chk = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            chk[result[0]][result[1]] = true;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i != j && chk[i][k] && chk[k][j]) {
                        chk[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            boolean pass = true;

            for (int j = 1; j < n + 1; j++) {
                if (i != j && !(chk[i][j] || chk[j][i])) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                answer++;
            }
        }

        return answer;
    }
}
