package com.code.codingtest.skillcheck.level2;

import com.sun.java.accessibility.util.GUIInitializedListener;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Tuple {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(new Tuple().solution(s)));
    }

    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        List<String[]> sElement = Arrays.stream(s.split("(},)"))
                .map(o -> o.replaceAll("[{}]", "").split(","))
                .collect(Collectors.toList());
        int[] answer = new int[sElement.size()];
        Set<Integer> useNum = new HashSet<>();
        int index = 0;
        sElement.sort(Comparator.comparingInt(o -> o.length));

        for (String[] s1 : sElement) {
            List<Integer> intList = Arrays.stream(s1).map(Integer::parseInt).collect(Collectors.toList());

            if (!useNum.isEmpty()) {
                intList.removeAll(useNum);
            }
            answer[index++] = intList.get(0);
            useNum.addAll(intList);
        }

        return answer;
    }
}
