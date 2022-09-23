package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem02 {
    /*
    순서가 보장된 튜플이 있음. 튜플을 나눈 배열이 주어질때 전체 튜플을 출력하기
    튜플을 나눈 배열은 순서 보장이 안되어 있음.

    ex> {3,2,4,1} = {{3}, {2,3}, {4,3,2}, {1,4,2,3}}
     */
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        System.out.println(Arrays.toString(new Problem02().solution(s)));
    }

    public int[] solution(String s) {
        List<String[]> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        String[] arr = s.split("},");

        for (String a : arr) {
            a = a.replaceAll("\\{","").replaceAll("}", "");
            String[] innerArr = a.split(",");

            list.add(innerArr);
        }

        list.sort(Comparator.comparingInt(o -> o.length));

        for (String[] innerArr : list) {
            for (String a : innerArr) {
                int value = Integer.parseInt(a);

                if (!answer.contains(value)) {
                    answer.add(value);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
