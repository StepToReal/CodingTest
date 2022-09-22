package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem02 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        System.out.println(Arrays.toString(new Problem02().solution(s)));
    }

    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        int[] answer;
        s = s.substring(1, s.length() - 1);
        String[] sArr = s.split("}");

        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = sArr[i].replaceAll("\\{","");
        }

        for (String s1 : sArr) {
            String[] s1Arr = s1.split(",");
            List<Integer> innerList = new ArrayList<>();

            for (int i = 0; i < s1Arr.length; i++) {
                if (!s1Arr[i].isEmpty()) {
                    int value = Integer.parseInt(s1Arr[i]);
                    innerList.add(value);
                }
            }

            list.add(innerList);
        }

        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for (List<Integer> innerList : list) {
            for (int value : innerList) {
                if (!answerList.contains(value)) {
                    answerList.add(value);
                }
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
