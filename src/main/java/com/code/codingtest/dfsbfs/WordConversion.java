package com.code.codingtest.dfsbfs;

import java.util.*;

public class WordConversion {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new WordConversion().solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        boolean[] visit = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word w = queue.poll();

            if (w.word.equals(target)) {
                answer = w.changeValue;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (visit[i]) continue;

                String wordsItem = words[i];
                int differentCharCount = 0;

                for (int j = 0; j < w.word.toCharArray().length; j++) {
                    if (wordsItem.charAt(j) != w.word.charAt(j)) {
                        differentCharCount++;
                    }
                }

                if (differentCharCount == 1) {
                    queue.add(new Word(wordsItem, ++w.changeValue));
                    visit[i] = true;
                }
            }
        }

        return answer;
    }
}

class Word {
    String word;
    int changeValue;

    public Word(String word, int changeValue) {
        this.word = word;
        this.changeValue = changeValue;
    }
}
