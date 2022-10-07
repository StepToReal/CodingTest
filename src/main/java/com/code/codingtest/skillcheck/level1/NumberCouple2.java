package com.code.codingtest.skillcheck.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberCouple2 {

    public static void main(String[] args) {
        String x = "100";
        String y = "123450";

//        StringBuffer a = new StringBuffer(3000000);
//        StringBuffer b = new StringBuffer(3000000);
//
//        for (int i = 0; i < 3000000; i++) {
//            a.append((int) (Math.random() * 10));
//            b.append((int) (Math.random() * 10));
//        }

        System.out.println(new NumberCouple2().solution(x,y));
    }

    public String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer(3000000);
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for (String x : X.split("")) {
            xArr[Integer.parseInt(x)]++;
        }

        for (String y : Y.split("")) {
            yArr[Integer.parseInt(y)]++;
        }

        for (int i = 9; i >= 0; i--) {
            int min = Math.min(xArr[i], yArr[i]);

            for (int j = 0; j < min; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) return "-1";
        else if (answer.indexOf("0") == 0) return "0";
        else return answer.toString();
    }
}
