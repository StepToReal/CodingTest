package com.code.codingtest.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SurveillanceCamera {
    public static void main(String[] args) {
//        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}}; //2
//        int[][] routes = {{-20,-15},{-18,-5},{-14,-13},{-10,-3}}; //2
        int[][] routes = {{-100,100},{50,170},{150,200},{-50,-10},{10,20},{30,40}}; //4
//        int[][] routes = {{0, 0}};

        System.out.println(new SurveillanceCamera().solution(routes));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int cameraCount = 0;

        List<int[]> list = new ArrayList<>(Arrays.asList(routes));

        while(list.size() > 0) {
            Iterator<int[]> iterator = list.iterator();
            int endPosition = list.get(0)[1];

            while (iterator.hasNext()) {
                int[] route = iterator.next();

                if (route[0] <= endPosition && route[1] >= endPosition) {
                    iterator.remove();
                }
            }

            cameraCount++;
        }

        return cameraCount;
    }
}
