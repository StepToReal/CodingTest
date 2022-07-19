package com.code.codingtest.greedy;

import java.util.Arrays;

public class SurveillanceCamera {
    public static void main(String[] args) {
        int[][] routes = {{2,4},{0,1},{-10,9} };

        System.out.println(new SurveillanceCamera().solution(routes));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> Integer.compare(a[0], b[0]));
        int cameraCnt = 0;
        int[] checkCars = new int[routes.length];

        for (int i = 0; i < routes.length - 1; i++) {
            
            for (int j = i + 1; j < routes.length; j++) {
                if (routes[i][1] >= routes[j][0]) {
                    checkCars[i] = 1;
                    checkCars[j] = 1;
                    cameraCnt++;
                }
            }

            cameraCnt++;
        }

        return cameraCnt;
    }
}
