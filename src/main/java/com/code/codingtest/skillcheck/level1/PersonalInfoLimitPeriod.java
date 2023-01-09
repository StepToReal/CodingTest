package com.code.codingtest.skillcheck.level1;

import java.util.*;

public class PersonalInfoLimitPeriod {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(new PersonalInfoLimitPeriod().solution2(today, terms, privacies)));
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] termElement = term.split(" ");
            termMap.put(termElement[0], Integer.parseInt(termElement[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyElement = privacies[i].split(" ");
            String[] ymd = privacyElement[0].split("\\.");

            int year = Integer.parseInt(ymd[0]);
            int month = Integer.parseInt(ymd[1]);
            int day = Integer.parseInt(ymd[2]);
            int term = termMap.get(privacyElement[1]);

            month += term;

            if (month > 12) {
                year += month / 12;
                month %= 12;

                if (month % 12 == 0) {
                    year -= 1;
                    month = 12;
                }
            }
            if (day == 1) {
                month -= 1;
                day = 28;
            } else {
                day -= 1;
            }

            String afterDay = String.format("%02d.%02d.%02d", year, month, day);

            if (today.compareTo(afterDay) > 0) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public int[] solution2(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        int date = getDate(today);

        for (String term : terms) {
            String[] termSplit = term.split(" ");
            termMap.put(termSplit[0], Integer.parseInt(termSplit[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            int limitDate = getDate(privacySplit[0]) + (termMap.get(privacySplit[1]) * 28);

            if (limitDate <= date) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int getDate(String day) {
        String[] date = day.split("\\.");
        int y = Integer.parseInt(date[0]);
        int m = Integer.parseInt(date[1]);
        int d = Integer.parseInt(date[2]);

        return (y * 12 * 28) + (m * 28) + d;
    }
}
