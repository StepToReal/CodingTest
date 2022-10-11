package com.code.codingtest.skillcheck.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MBTITest {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(new MBTITest().solution(survey, choices));
    }

    //RT CF JM AN
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        List<Mbti> mbtiList = new ArrayList<>();

        mbtiList.add(new Mbti("R", "T"));
        mbtiList.add(new Mbti("C", "F"));
        mbtiList.add(new Mbti("J", "M"));
        mbtiList.add(new Mbti("A", "N"));

        for (int i = 0; i < survey.length; i++) {
            String surv = survey[i];
            int num = choices[i];

            if (num < 4) {
                surv = surv.substring(0, 1);
                num = 4 - num;
            } else if (num > 4) {
                surv = surv.substring(1, 2);
                num -= 4;
            } else {
                continue;
            }

            for (Mbti mbti : mbtiList) {
                if (mbti.type1.equals(surv) || mbti.type2.equals(surv)) {
                    mbti.map.replace(surv, mbti.map.get(surv) + num);
                }
            }
        }

        for (Mbti mbti : mbtiList) {
            answer.append(mbti.getType());
        }

        return answer.toString();
    }
}

class Mbti {

    Map<String, Integer> map = new HashMap<>();
    String type1;
    String type2;

    Mbti(String type1, String type2) {
        map.put(type1, 0);
        map.put(type2, 0);

        this.type1 = type1;
        this.type2 = type2;
    }

    public String getType() {
        if (map.get(type1) > map.get(type2)) {
            return type1;
        } else if (map.get(type1) < map.get(type2)) {
            return type2;
        } else {
            return type1.compareTo(type2) <= 0 ? type1 : type2;
        }
    }
}