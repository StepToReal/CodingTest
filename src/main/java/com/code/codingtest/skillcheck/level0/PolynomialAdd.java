package com.code.codingtest.skillcheck.level0;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolynomialAdd {
    public static void main(String[] args) {
        System.out.println(new PolynomialAdd().solution("3x + 7 + x"));
    }

    public String solution(String polynomial) {

        String[] sArr = polynomial.split("\\+");
        int xVariable = 0;
        int variable = 0;

        for (String s : sArr) {
            s = s.trim();
            if (s.endsWith("x")) {
                if (s.equals("x")) { s = "1x"; }
                xVariable += Integer.parseInt(s.substring(0, s.length() - 1));
            } else {
                variable += Integer.parseInt(s);
            }
        }

        List<String> resultList = new ArrayList<>();
        if (xVariable != 0) {
            String xResult = xVariable + "x";

            if (xVariable == 1 || xVariable == -1) {
                xResult = xResult.replace("1", "");
            }

            resultList.add(xResult);
        }
        if (variable != 0) resultList.add(variable + "");

        return String.join(" + ", resultList);
    }
}
