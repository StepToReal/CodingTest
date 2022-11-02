package com.code.codingtest.skillcheck.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Babbling {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa", "mwooa"};

        System.out.println(new Babbling().solution(babbling));
    }

    public int solution(String[] babbling) {
        int answer = 0;
        List<String> possibleList = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));

        for (String b : babbling) {
            for (String possible : possibleList) {
                if (b.contains(possible + possible)) {
                    break;
                }

                b = b.replace(possible, " ");
            }

            if (b.trim().length() == 0) answer++;
        }

        return answer;
    }
}
