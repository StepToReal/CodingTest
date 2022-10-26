package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JewelryShopping {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        System.out.println(Arrays.toString(new JewelryShopping().solution(gems)));
    }

    //시간초과 발생
    public int[] solution(String[] gems) {
        Set<String> gemFullSet = new HashSet<>(Arrays.asList(gems));
        Set<String> gemSet;
        int[] answer = new int[2];

        int size = gemFullSet.size();

        Loop:
        for (; size <= gems.length; size++) {
            for (int i = 0; i + size <= gems.length; i++) {
                gemSet = new HashSet<>(Arrays.asList(gems).subList(i, i + size));

                if (gemSet.containsAll(gemFullSet)) {
                    answer[0] = i + 1;
                    answer[1] = i + size;
                    break Loop;
                }
            }
        }

        return answer;
    }
}
