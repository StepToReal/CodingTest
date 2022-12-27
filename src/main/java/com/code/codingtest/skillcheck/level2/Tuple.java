package com.code.codingtest.skillcheck.level2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(new Tuple().solution(s)));
    }

    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();

        String[] sElement = s.split("},");
        int[] answer = new int[sElement.length];

        for (String s1 : sElement) {
            s1 = s1.replace("{","").replace("}","");
            List<Integer> intList = Arrays.stream(s1.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            list.add(intList);
        }

        list.sort(Comparator.comparingInt(List::size));
        Set<Integer> useNum = new HashSet<>();

        answer[0] = list.get(0).get(0);
        useNum.add(list.get(0).get(0));

        for (int i = 1; i < list.size(); i++) {
            List<Integer> tuple = list.get(i);
            tuple.removeAll(useNum);
            answer[i] = tuple.get(0);
            useNum.add(tuple.get(0));
        }

        return answer;
    }
}
