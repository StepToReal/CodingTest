package com.code.codingtest.dynamicprogramming;

public class GoingToSchoolOtherSolve1 {
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
//        int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};
        int[][] puddles = {{2,2}};

        System.out.println(new GoingToSchoolOtherSolve1().solution(width, height, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        //m,n 변경하지 않고도 그대로 풀 수 있을듯 하다. 일단 그렇게 접근해 보자
        /*
            m,n을 바꾸지 않고 풀어도 동일한 결과를 얻을 수 있다.
            m,n을 변경하는건 예제와 동일한 그림에 행렬을 만들기 위함일 뿐, 변경하지 않아도 결과는 같다.
         */
        int mod = 1000000007;
        int[][] map = new int[m+1][n+1];

        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = -1;
        }

        map[1][1] = 1;
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                if (i != 1 || j != 1)
                    map[i][j] = map[i-1][j] % mod + map[i][j - 1] % mod;
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        return map[m][n];
    }
}
