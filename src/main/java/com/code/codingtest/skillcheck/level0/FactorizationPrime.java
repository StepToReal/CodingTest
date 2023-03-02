package com.code.codingtest.skillcheck.level0;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactorizationPrime {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FactorizationPrime().solution(34)));
    }

    public int[] solution(int n) {
        Set<Integer> answer = new HashSet<>();

        int divider = 2;

        while (n > 1) {
            if (n % divider == 0) {
                answer.add(divider);
                n = n / divider;
            } else {
                divider++;
            }
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(int n) {
        int[] arr = IntStream.rangeClosed(2, n / 2).filter(i -> n % i == 0).toArray();

        if (arr.length == 0) return new int[] {n};
        else {
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] % arr[j] == 0) {
                        arr[i] = -1;
                    }
                }
            }

            return Arrays.stream(arr).filter(i -> i != -1).toArray();
        }
    }
}
