package com.code.codingtest.skillcheck.level2;

public class VowelDictionary {
    public static void main(String[] args) {
        System.out.println(new VowelDictionary().solution("AAAAE"));
    }

    String[] vowels = {"A", "E", "I", "O", "U"};
    int answer = -1;
    int count = 0;

    public int solution(String word) {
        dfs(word, "");
        return answer;
    }

    private void dfs(String word, String makeWord) {
//        if (word.equals(makeWord)) {
//            answer = count;
//            return;
//        }
        System.out.println(count + ", " + makeWord);

        for (int i = 0; i < vowels.length; i++) {
            if (answer != -1) break;
            if (makeWord.length() == 5) break;
            count++;
            dfs(word, makeWord + vowels[i]);
        }
    }
}
