package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TwoElementSum {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(new TwoElementSum().solution2(numbers)));
    }

    int[] numbers;
    int[] temp = new int[2];
    Set<Integer> set = new TreeSet<>();

    public int[] solution(int[] numbers) {
        this.numbers = numbers;
        bt(0, 0);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bt(int at, int depth) {
        if (depth == 2) {
            set.add(temp[0] + temp[1]);
            System.out.println(Arrays.toString(temp));
            return;
        }

        for (int i = at; i < numbers.length; i++) {
            temp[depth] = numbers[i];
            bt(i + 1, depth + 1);
        }
    }

    public int[] solution2(int[] numbers) {
        bt2(numbers, 0, 0, 0);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bt2(int[] numbers, int at, int depth, int sum) {
        if (depth == 2) {
            set.add(sum);
            return;
        }

        for (int i = at; i < numbers.length; i++) {
            bt2(numbers, i + 1, depth + 1, sum + numbers[i]);
        }
    }
}
