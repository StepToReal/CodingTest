package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NearestSameWord {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NearestSameWord().solution("banana")));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (charMap.containsKey(c)) {
                answer[i] = i - charMap.get(c);
            } else {
                answer[i] = -1;
            }

            charMap.put(c, i);
        }

        return answer;
    }
}
