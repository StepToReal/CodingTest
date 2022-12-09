package com.code.algorithm.shortdistance;

public class FloydWarshall {
    public static void main(String[] args) {
//        int[][] maps = {{1,2,5}, {2,1,7},{3,1,2},{1,4,8},{2,3,9},
//                {3,4,4}, {4,3,3}};

        int[][] maps = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int n = 6;

        solution(maps, n);
    }

    private static void solution(int[][] maps, int n) {
        int[][] floyd = new int[n][n];
        int[][] middlePoint = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    floyd[i][j] = 0;
                else
                    floyd[i][j] = 1000000000;
            }
        }

        // 결과 그래프 값 채우기 - 다이랙트로 연결된 포인트 값
        for (int i = 0; i < maps.length; i++) {
            floyd[maps[i][0] - 1][maps[i][1] - 1] = maps[i][2];
            floyd[maps[i][1] - 1][maps[i][0] - 1] = maps[i][2];
        }

        // k 거쳐가는 노드, 기준 노드
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) { // 출발 노드
                for (int j = 0; j < n; j++) { //도착 노드

                    // i -> j 가는 최소비용 vs (i -> k) + (k -> j) 로 가는 비용
                    if (floyd[i][k] + floyd[k][j] < floyd[i][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        middlePoint[i][j] = k;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("`" + floyd[i][j] + "-" + middlePoint[i][j] + " ");
            }
            System.out.println();
        }
    }


}
