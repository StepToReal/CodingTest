package com.code.codingtest.skillcheck.level1;

import java.util.HashMap;
import java.util.Map;

public class MemoriesScore {
    public static void main(String[] args) {

    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int index = 0;
        for (String[] pArray : photo) {
            int score = 0;
            for (String p : pArray) {
                score += map.getOrDefault(p, 0);
            }

            answer[index++] = score;
        }

        return answer;
    }
}
