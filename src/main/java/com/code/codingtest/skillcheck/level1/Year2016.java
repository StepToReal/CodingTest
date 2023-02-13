package com.code.codingtest.skillcheck.level1;

import java.time.LocalDate;

public class Year2016 {
    public static void main(String[] args) {

    }

    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        return date.getDayOfWeek().name().substring(0, 3);
    }

    public String solution2(int a, int b) {
        String answer = "";
        int[] monthLastDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < a - 1; i++) {
            b += monthLastDay[i];
        }

        switch (b % 7) {
            case 1:answer="FRI";break;
            case 2:answer="SAT";break;
            case 3:answer="SUN";break;
            case 4:answer="MON";break;
            case 5:answer="TUE";break;
            case 6:answer="WED";break;
            case 0:answer="THU";break;
        }

        return answer;
    }
}
