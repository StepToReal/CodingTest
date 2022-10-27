package com.code.codingtest.skillcheck.level0;

public class CurseNumber3 {
    public static void main(String[] args) {
        System.out.println(new CurseNumber3().solution(10));
    }

    public int solution(int n) {
//        int[] arr = new int[n + 1];
//        int num = 1;
//
//        for (int i = 1; i < arr.length; i++) {
//            if (num % 3 == 0 || String.valueOf(num).contains("3")){
//                i--;
//            } else {
//                arr[i] = num;
//            }
//
//            num++;
//        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer++;

            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }
}
