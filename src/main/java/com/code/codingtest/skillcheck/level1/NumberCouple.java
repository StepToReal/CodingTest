package com.code.codingtest.skillcheck.level1;

import com.sun.org.apache.xml.internal.utils.XMLChar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberCouple {

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

        System.out.println(new NumberCouple().solution(x,y));
    }

    public String solution(String X, String Y) {
        List<String> list = new ArrayList<>();

        String[] xArr = X.split("");
        String[] yArr = Y.split("");

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        StringBuffer sbX = new StringBuffer(xArr.length);
        StringBuffer sbY = new StringBuffer(yArr.length);

        for (String s : xArr) {
            sbX.append(s);
        }

        for (String s : yArr) {
            sbY.append(s);
        }

        for (int i = 9; i >= 0; i--) {
            String s = String.valueOf(i);
            int xCount = 0;
            int yCount = 0;

            if (sbX.indexOf(s) == -1 || sbY.indexOf(s) == -1) {
                continue;
            } else {
                xCount = sbX.lastIndexOf(s) - sbX.indexOf(s) + 1;
                yCount = sbY.lastIndexOf(s) - sbY.indexOf(s) + 1;
            }

            int min = Math.min(xCount, yCount);

            for (int j = 0; j < min; j++) {
                list.add(s);
            }
        }

        if (list.isEmpty()) {
            return "-1";
        } else if (list.get(0).equals("0")) {
            return "0";
        } else {
            StringBuffer answer = new StringBuffer();

            for (String s : list) {
                answer.append(s);
            }
            return answer.toString();
        }
    }
}
