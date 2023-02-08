package com.code.codingtest.skillcheck.level3;

public class PedestrianParadise2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 6;
//        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 2, 0}};
        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        System.out.println(new PedestrianParadise2().solution(m, n, cityMap));
    }

    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        //0 free, 1 stop , 2 only straight
        int[][][] map = new int[m][n][2]; // 3차 0은 수평, 1은 수직

        map[0][0][0] = 1;
        map[0][0][1] = 1;

        for (int i = 1; i < m; i++) {
            if (cityMap[i][0] != 1)
                map[i][0][1] = map[i - 1][0][1];
        }

        for (int i = 1; i < n; i++) {
            if (cityMap[0][i] != 1)
                map[0][i][0] = map[0][i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] != 1) {
                    if (cityMap[i - 1][j] == 2) {
                        map[i][j][1] = map[i - 1][j][1];
                    } else {
                        map[i][j][1] = (map[i - 1][j][0] + map[i - 1][j][1]) % MOD;
                    }
                    if (cityMap[i][j - 1] == 2) {
                        map[i][j][0] = map[i][j - 1][0];
                    } else {
                        map[i][j][0] = (map[i][j - 1][0] + map[i][j - 1][1]) % MOD;
                    }
                }
            }
        }

        return (map[m - 1][n - 1][0] + map[m - 1][n - 1][1]) % MOD;
    }
}
