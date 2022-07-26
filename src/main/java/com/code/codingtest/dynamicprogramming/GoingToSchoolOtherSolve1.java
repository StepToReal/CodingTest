package com.code.codingtest.dynamicprogramming;

public class GoingToSchoolOtherSolve1 {
    public static void main(String[] args) {
        int width = 7;
        int height = 4;
        int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};

        System.out.println(new GoingToSchoolOtherSolve1().solution(width, height, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        //m,n 변경하지 않고도 그대로 풀 수 있을듯 하다. 일단 그렇게 접근해 보자
        return 0;
    }
}
