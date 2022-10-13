package com.code.codingtest.skillcheck.level1;

public class RecommendNewId {
    public static void main(String[] args) {
        String new_id = "=.=";

        System.out.println(new RecommendNewId().solution(new_id));
    }

    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^a-z0-9\\._-]", "")
                .replaceAll("\\.{2,}", ".");

        if (answer.startsWith(".")) answer = answer.substring(1);
        if (answer.endsWith(".")) answer = answer.substring(0,answer.length() - 1);

        if (answer.isEmpty()) answer = "a";

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) answer = answer.substring(0,answer.length() - 1);
        }

        if (answer.length() <= 2) {
            for (int i = answer.length(); i < 3; i++) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
