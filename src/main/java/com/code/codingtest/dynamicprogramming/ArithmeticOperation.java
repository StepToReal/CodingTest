package com.code.codingtest.dynamicprogramming;

public class ArithmeticOperation {
    int[][][] dp = new int[2][200][200]; //dp 1차원에 0은 최대 테이블, 1은 최소 테이블
    char[] oper;
    int[] nums;
    String[] arr;

    public static void main(String[] args) {
        String[] arr2 = {"1", "-", "3", "+", "5", "-", "8"}; //1
        String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"}; //3

        System.out.println(new ArithmeticOperation().solution(arr));
    }

    public int solution(String arr[]) {
        int answer = -1;
        this.arr = arr;
        init();

        return answer = solve(0, 0, arr.length / 2);
    }

    //db 테이블 초기화
    private void init(){
        int n = arr.length/2;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[0][i][j] = Integer.MIN_VALUE; //최대값이 저장될 테이블
                dp[1][i][j] = Integer.MAX_VALUE;      //최소값이 저장될 테이블
            }
        }

        nums = new int[n + 1];
        oper = new char[n];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]); //arr 배열에 짝수는 숫자 -> nums 에 저장
            else oper[i / 2] = arr[i].charAt(0);                    //arr 배열에 홀수는 연산자 -> oper 에 저장
        }
    }

    private int solve(int flag, int start, int end) {  //처음에는 0, 0, arr.length/2 값이 들어온다. 배열이기 때무에 arr.length/2 면 끝까지 가능
        //범위가 숫자 하나로 일치하는 경우
        if (start == end) {
            return dp[flag][start][end] = nums[start];
        }

        //이미 해결했던 문제라면
        if (flag == 0 && dp[flag][start][end] != Integer.MIN_VALUE)
            return dp[flag][start][end];
        if (flag == 1 && dp[flag][start][end] != Integer.MAX_VALUE)
            return dp[flag][start][end];

        //flag에 따라 초기값을 다르게 줌
        int ret = (flag == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        //방문체크
        dp[flag][start][end] = 0;

        if (flag == 0) {
            //최대를 구해야 하는 경우
            for (int mid = start; mid < end; mid++) {
                if (oper[mid] == '-') {
                    //두 구간 사이 연산자가 - 일 때, 최대 - 최소
                    ret = Math.max(ret, solve(0, start, mid) - solve(1, mid + 1, end));
                } else {
                    //두 구간 사이의 연산자가 +일때, 최대 + 최대
                    ret = Math.max(ret, solve(0, start, mid) + solve(0, mid + 1, end));
                }
            }
        } else {
            //최소를 구해야 하는 경우
            for (int mid = start; mid < end; mid++) {
                if (oper[mid] == '-') {
                    //두 구간 사이의 연산자가 -일때, 최소 - 최대
                    ret = Math.min(ret, solve(1, start, mid) - solve(0, mid + 1, end));
                } else {
                    //두 구간 사이의 연산자가 +일때, 최소 + 최소
                    ret = Math.min(ret, solve(1, start, mid) + solve(1, mid + 1, end));
                }
            }
        }

        return dp[flag][start][end] = ret;
    }
}
