package com.code.codingtest.skillcheck.level3;

public class BaseStationInstallation2 {
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 2;

        System.out.println(new BaseStationInstallation2().solution(n, stations, w));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int stationEnd = 0;

        for (int station : stations) {
            if (station - w <= 1) {
                stationEnd = station + w;
            } else {
                int gap = (station - w) - stationEnd - 1;
                answer += Math.ceil((double)gap / coverage);
                stationEnd = station + w;
            }
        }

        if (stationEnd < n) {
            answer += Math.ceil(((double)n - stationEnd) / coverage);
        }

        return answer;
    }
}
