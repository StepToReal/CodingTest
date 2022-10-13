package com.code.codingtest.skillcheck.level1;

public class Trio {
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};

        System.out.println(new Trio().solution(number));
    }

    public int solution(int[] number) {
        //3개의 수를 합해서 0을 만드는 경우의 수
        int answer = 0;

        for (int i = 0; i < number.length-2; i++) {
            for (int j = i + 1; j < number.length-1; j++) {
                for (int k = j + 1; k < number.length; k++) {

                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
