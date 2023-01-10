package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class PickTangerine {
    public static void main(String[] args) {
        int k = 1;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(new PickTangerine().solution(k, tangerine));
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerineMap = new HashMap<>();

        for (int tang : tangerine) {
            tangerineMap.put(tang, tangerineMap.getOrDefault(tang, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(tangerineMap.values());
        list.sort(Comparator.reverseOrder());

        int temp = 0;
        for (Integer l : list) {
            temp += l;
            answer++;

            if (temp >= k) {
                break;
            }
        }

        return answer;
    }
}
