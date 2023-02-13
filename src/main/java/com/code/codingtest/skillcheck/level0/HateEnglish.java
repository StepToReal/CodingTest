package com.code.codingtest.skillcheck.level0;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class HateEnglish {
    public static void main(String[] args) {
        System.out.println(new HateEnglish().solution("onetwothreefourfivesixseveneightnine"));
        System.out.println(new HateEnglish().solution2("onetwothreefourfivesixseveneightnine"));
    }

    enum num {
        one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), zero(0);

        private int value;

        num(int value) {
            this.value = value;
        }

        int getValue() { return value; }
    }

    public long solution(String numbers) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numbers.length(); i++) {
            Loop:
            for (int j = i + 1; j <= numbers.length(); j++) {
                for (num n : num.values()) {
                    if (n.name().equals(numbers.substring(i, j))) {
                        answer.append(n.getValue());
                        i = j - 1;
                        break Loop;
                    }
                }
            }
        }

        return Long.parseLong(answer.toString());
    }

    public long solution2(String numbers) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < nums.length; i++) {
            numbers = numbers.replaceAll(nums[i], String.valueOf(i));
        }

        return Long.parseLong(numbers);
    }
}
