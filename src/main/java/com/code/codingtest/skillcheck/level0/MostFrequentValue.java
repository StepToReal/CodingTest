package com.code.codingtest.skillcheck.level0;

import java.util.*;

public class MostFrequentValue {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};

        System.out.println(new MostFrequentValue().solution(array));
    }

    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : array) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        if (list.size() == 1) {
            return array[0];
        }
        else if (list.get(0) == list.get(1)) {
            return -1;
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == list.get(0)) {
                    return entry.getKey();
                }
            }
        }

        return -1;
    }
}
