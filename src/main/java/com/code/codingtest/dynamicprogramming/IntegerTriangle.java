package com.code.codingtest.dynamicprogramming;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        int[][] triangle = {{7}, {3, 8}, {8, 1, 9}, {2, 7, 4, 9}};

        System.out.println(new IntegerTriangle().solution(triangle));
    }

    public int solution(int[][] triangle) {
        int sum = 0;
        int j = 0;

        for (int i = 0; i < triangle.length; i++) {
            if (i == 0) sum += triangle[0][0];

            if (i < triangle.length - 2) {
                // 앞 두 단의 값을 읽어 최대값을 비교 해야함.
                int a1 = triangle[i + 1][j] + triangle[i + 2][j];
                int a2 = triangle[i + 1][j] + triangle[i + 2][j + 1];
                int b1 = triangle[i + 1][j + 1] + triangle[i + 2][j + 1];
                int b2 = triangle[i + 1][j + 1] + triangle[i + 2][j + 2];

                int max = Math.max(Math.max(Math.max(a1, a2), b1), b2);

                if (max == b1 || max == b2) {
                    j++;
                }

                sum += triangle[i + 1][j];

            } else if (i == triangle.length - 2){
                sum += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
                break;
            }
        }

        return sum;
    }
}
