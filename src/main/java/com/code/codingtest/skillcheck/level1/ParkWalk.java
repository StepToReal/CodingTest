package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;

public class ParkWalk {
    public static void main(String[] args) {
        String[] park = {"OXO", "XSX", "OXO"};
        String[] routes = {"S 1", "E 1", "W 1", "N 1"};

        System.out.println(Arrays.toString(new ParkWalk().solution(park, routes)));
    }

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }

        for (String route : routes) {
            String direct = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);

            switch (direct) {
                case "E":
                    if (isWalk(park, answer, 0, distance)) {
                        answer[1] += distance;
                    }
                    break;
                case "W":
                    if (isWalk(park, answer, 0, -distance)) {
                        answer[1] -= distance;
                    }
                    break;
                case "N":
                    if (isWalk(park, answer, -distance, 0)) {
                        answer[0] -= distance;
                    }
                    break;
                case "S":
                    if (isWalk(park, answer, distance, 0)) {
                        answer[0] += distance;
                    }
                    break;
            }
        }

        return answer;
    }

    private boolean isWalk(String[] park, int[] answer, int h, int w) {
        if (answer[0] + h < 0 || answer[0] + h >= park.length ||
                answer[1] + w < 0 || answer[1] + w >= park[0].length()) {
            return false;
        } else {
            int code = 1;
            if (h < 0 || w < 0) code = -1;

            for (int i = 1; i <= h * code; i++) {
                if (park[answer[0] + (i * code)].charAt(answer[1]) == 'X') return false;
            }

            for (int i = 1; i <= w * code; i++) {
                if (park[answer[0]].charAt(answer[1] + (i * code)) == 'X') return false;
            }
        }
        return true;
    }
}
