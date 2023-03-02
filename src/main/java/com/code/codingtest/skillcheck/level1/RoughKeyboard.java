package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoughKeyboard {
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};

        System.out.println(Arrays.toString(new RoughKeyboard().solution(keymap, targets)));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> keys = new HashMap<>();

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                String s = String.valueOf(key.charAt(i));
                keys.put(s, Math.min(keys.getOrDefault(s, 100), i + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];

            for (int j = 0; j < target.length(); j++) {
                String s = String.valueOf(target.charAt(j));

                if (keys.containsKey(s)) {
                    answer[i] += keys.get(s);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
