package com.code.codingtest.skillcheck.level1;

import java.util.*;

public class ReceiveReportResult {
    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        System.out.println(Arrays.toString(new ReceiveReportResult().solution(id_list, report, k)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> userReport = new HashMap<>();
        Map<String, Integer> reportSummary = new HashMap<>();

        for (String s : report) {
            String[] sArr = s.split(" ");

            if (userReport.containsKey(sArr[0])) {
                userReport.get(sArr[0]).add(sArr[1]);
            } else {
                Set<String> set = new HashSet<>();
                set.add(sArr[1]);

                userReport.put(sArr[0], set);
            }
        }

        for (Map.Entry<String, Set<String>> entry : userReport.entrySet()) {
            for (String s : entry.getValue()) {
                if (reportSummary.containsKey(s)) {
                    reportSummary.put(s, reportSummary.get(s) + 1);
                } else {
                    reportSummary.put(s, 1);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            String id = id_list[i];
            int mailCount = 0;

            if (userReport.containsKey(id)) {
                for (String reportedUserName : userReport.get(id)) {
                    if (reportSummary.containsKey(reportedUserName) && reportSummary.get(reportedUserName) >= k) {
                        mailCount++;
                    }
                }
            }

            answer[i] = mailCount;
        }

        return answer;
    }
}