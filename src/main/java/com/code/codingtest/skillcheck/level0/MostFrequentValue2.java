package com.code.codingtest.skillcheck.level0;

import java.util.*;

public class MostFrequentValue2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};

        System.out.println(new MostFrequentValue2().solution(array));
    }

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : array) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        if (list.size() > 1) {
            if (list.get(0).getValue() == list.get(1).getValue()) {
                return -1;
            }
        }

        return list.get(0).getValue();
    }
}
