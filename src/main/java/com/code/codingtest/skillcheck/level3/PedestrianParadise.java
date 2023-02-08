package com.code.codingtest.skillcheck.level3;

public class PedestrianParadise {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(new PedestrianParadise().solution(m, n, cityMap));
    }

    int answer = 0;
    int m, n;
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        //0 free, 1 stop , 2 only straight
        this.m = m;
        this.n = n;

        dfs(0, 0, cityMap, "");

        return answer;
    }

    //dfs로 풀면 시간초과 남. 2 에서는 DP 로 풀어볼것.
    public void dfs(int x, int y, int[][] cityMap, String prevDirection) {
        if (x == m - 1 && y == n - 1) {
            answer = (answer + 1) % MOD;
            return;
        }

        if (cityMap[x][y] == 2) {
            if (prevDirection.equals("r")) {
                if (x + 1 < m && cityMap[x + 1][y] != 1) {
                    dfs(x + 1, y, cityMap, "r");
                }
            } else {
                if (y + 1 < n && cityMap[x][y + 1] != 1) {
                    dfs(x, y + 1, cityMap, "d");
                }
            }
        } else {
            if (x + 1 < m && cityMap[x + 1][y] != 1) {
                dfs(x + 1, y, cityMap, "r");
            }

            if (y + 1 < n && cityMap[x][y + 1] != 1) {
                dfs(x, y + 1, cityMap, "d");
            }
        }
    }
}
