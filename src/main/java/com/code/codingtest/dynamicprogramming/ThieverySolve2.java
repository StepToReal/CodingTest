package com.code.codingtest.dynamicprogramming;

public class ThieverySolve2 {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1}; //4
        int[] money2 = {8, 9, 7, 9, 10, 9}; //27
        int[] money3 = {99,60,1,51,100,51};

        System.out.println(new ThieverySolve2().solution(money));
    }

    /*
    첫집을 털었는지 안털었는지 경우를 나눠 계산하고 두 경우 중 마지막 합산 값이 가장 큰 경우를 선택한다.
    점화식을 세우는게 관건인데 해당 문제의 점화식은 아래와 같다.
    dp[i] = max (dp[i-1], money[i] + dp[i-2])
     */
    public int solution(int[] money) {
        int len = money.length;
        int[] dpInclude0 = new int[len];
        int[] dpExclude0 = new int[len];

        dpInclude0[0] = dpInclude0[1] = money[0];
        dpExclude0[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpInclude0[i] = Math.max(dpInclude0[i - 1], money[i] + dpInclude0[i - 2]);
            dpExclude0[i] = Math.max(dpExclude0[i - 1], money[i] + dpExclude0[i - 2]);
        }

        return Math.max(dpInclude0[len - 2], dpExclude0[len - 1]);
    }
}
