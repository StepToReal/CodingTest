package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InsertAdvertisement {
    public static void main(String[] args) {
        String playTime = "02:03:55";
        String advTime = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(new InsertAdvertisement().solution(playTime, advTime, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        if (play_time.equals(adv_time)) {
            return "00:00:00";
        }

        int playTime = convertTimeToInt(play_time);
        int advTime = convertTimeToInt(adv_time);

        List<PlayTime> playList = new ArrayList<>();
        List<Integer> checkPoints = new ArrayList<>();

        for (String log : logs) {
            String[] logElements = log.split("-");
            int startTime = convertTimeToInt(logElements[0]);
            int endTime = convertTimeToInt(logElements[1]);

            PlayTime pt = new PlayTime(startTime, endTime);
            playList.add(pt);

            checkPoints.add(startTime);
            checkPoints.add(endTime);
        }

        checkPoints.sort(Integer::compare);

        int advStart = 0;
        int checkPointIndex = 0;
        int maxTime = 0;
        int maxIndex = 0;

        while (advStart + advTime <= playTime) {
            int sumTime = 0;
            int startTime = advStart;
            int endTime = advStart + advTime;

            for (PlayTime pt : playList) {
                int includeTime = pt.includeTime(startTime, endTime);

                if (includeTime != -1) {
                    sumTime += includeTime;
                }
            }

            if (maxTime < sumTime) {
                maxTime = sumTime;
                maxIndex = advStart;
            }

            advStart = checkPoints.get(checkPointIndex++);
        }

        return convertIntTimeToString(maxIndex);
    }

    private int convertTimeToInt(String time) {
        int[] timeArr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return timeArr[0] * 60 * 60 + timeArr[1] * 60 + timeArr[2];
    }

    private String convertIntTimeToString(int time) {
        String[] times = new String[3];

        for (int i = 2; i >= 1; i--) {
            times[i] = String.format("%02d", time % 60);
            time /= 60;
        }

        times[0] = String.format("%02d",time);

        return String.join(":", times);
    }
}

class PlayTime {
    int start;
    int end;

    public PlayTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int includeTime(int targetStart, int targetEnd) {
        if (targetEnd < start || targetStart > end) {
            return -1;
        } else {
            return Math.min(end, targetEnd) - Math.max(start, targetStart);
        }
    }
}