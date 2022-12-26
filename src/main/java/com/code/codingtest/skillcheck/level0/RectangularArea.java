package com.code.codingtest.skillcheck.level0;

public class RectangularArea {
    public static void main(String[] args) {
        int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
        System.out.println(new RectangularArea().solution(dots));
    }

    public int solution(int[][] dots) {
        int xMin = dots[0][0];
        int xMax = dots[0][0];
        int yMin = dots[0][1];
        int yMax = dots[0][1];

        for (int[] dot : dots) {
            xMin = Math.min(xMin, dot[0]);
            xMax = Math.max(xMax, dot[0]);
            yMin = Math.min(yMin, dot[1]);
            yMax = Math.max(yMax, dot[1]);
        }

        return (xMax - xMin) * (yMax - yMin);
    }
}
