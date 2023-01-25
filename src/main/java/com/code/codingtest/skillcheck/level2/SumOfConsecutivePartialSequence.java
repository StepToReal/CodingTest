package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfConsecutivePartialSequence {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};

        System.out.println(new SumOfConsecutivePartialSequence().solution(elements));
    }

    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        for (int consecutive = 1; consecutive < elements.length; consecutive++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;

                for (int j = 0; j < consecutive; j++) {
                    sum += elements[(i + j) % elements.length];
                }
                sums.add(sum);
            }
        }

        sums.add(Arrays.stream(elements).sum());

        return sums.size();
    }
}
