package com.code.codingtest.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SurveillanceCameraImprove {

    public static void main(String[] args) {
//        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}}; //2
//        int[][] routes = {{-20,-15},{-18,-5},{-14,-13},{-10,-3}}; //2
        int[][] routes = {{-100,100},{50,170},{150,200},{-50,-10},{10,20},{30,40}}; //4
//        int[][] routes = {{0, 0}};

        System.out.println(new SurveillanceCamera().solution(routes));
    }

    //도작 시간을 기준으로 다음 route 의 시작 시간과 비교하여 카메라 위치 정의.
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastCamera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (lastCamera < route[0]) {
                count++;
                lastCamera = route[1];
            }
        }

        return count;
    }
}
