package com.code.codingtest.skillcheck.level1;

public class MinimumSquare {
    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;

        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                widthMax = Math.max(widthMax, size[0]);
                heightMax = Math.max(heightMax, size[1]);
            } else {
                widthMax = Math.max(widthMax, size[1]);
                heightMax = Math.max(heightMax, size[0]);
            }
        }

        return widthMax * heightMax;
    }
}
