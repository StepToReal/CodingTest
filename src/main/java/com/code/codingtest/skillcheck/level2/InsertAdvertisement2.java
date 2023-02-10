package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertAdvertisement2 {
    public static void main(String[] args) {
        String playTime = "02:03:55";
        String advTime = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(new InsertAdvertisement2().solution(playTime, advTime, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertTimeToInt(play_time);
        int advTime = convertTimeToInt(adv_time);
        int[] sumArr = new int[playTime + 1];

        for (String log : logs) {
            String[] logElement = log.split("-");
            int startTime = convertTimeToInt(logElement[0]);
            int endTime = convertTimeToInt(logElement[1]);

            for (int i = startTime; i < endTime; i++) {
                sumArr[i]++;
            }
        }

        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += sumArr[i];
        }

        long maxTime = sum;
        int maxIndex = 0;
        for (int i = 1, j = advTime; j < playTime; i++, j++) {
            sum += sumArr[j] - sumArr[i - 1];

            if (maxTime < sum) {
                maxTime = sum;
                maxIndex = i;
            }
        }

        return convertIntTimeToString(maxIndex);
    }

    private int convertTimeToInt(String time) {
        int[] timeArr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return timeArr[0] * 60 * 60 + timeArr[1] * 60 + timeArr[2];
    }

    private String convertIntTimeToString(int time) {
        int hh = time / 3600;
        time %= 3600;
        int mm = time / 60;
        time %= 60;
        int ss = time;

        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }
}