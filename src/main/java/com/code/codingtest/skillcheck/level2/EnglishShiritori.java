package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnglishShiritori {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(new EnglishShiritori().solution(n, words)));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> useWords = new ArrayList<>();

        useWords.add(words[0]);
        String prevWord = words[0];

        for (int i = 1; i < words.length; i++) {
            String w = words[i];

            if (useWords.contains(w) ||
                    prevWord.charAt(prevWord.length() - 1) != w.charAt(0)) {
                //do something
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;

                break;
            }

            useWords.add(w);
            prevWord = w;
        }

        return answer;
    }
}
