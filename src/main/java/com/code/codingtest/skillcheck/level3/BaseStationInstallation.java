package com.code.codingtest.skillcheck.level3;

public class BaseStationInstallation {
    public static void main(String[] args) {
        int n = 4;
        int[] stations = {1,2,3,4};
        int w = 6;

        System.out.println(new BaseStationInstallation().solution(n, stations, w));
    }

    // 정확도는 모두 통과 효율성은 모두 실패..
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean[] isCovered = new boolean[n + 1];
        isCovered[0] = true;

        for (int station : stations) {
            for (int i = Math.max(station - w, 0); i <= station + w && i < isCovered.length; i++) {
                isCovered[i] = true;
            }
        }

        int unCoveredCount = 0;

        for (int i = 1; i < isCovered.length; i++) {
            if (!isCovered[i]) {
                unCoveredCount++;

                if (i == isCovered.length - 1 || isCovered[i + 1] || unCoveredCount == w + 1) {
                    answer++;

                    for (int j = Math.max(i - w, 0); j <= i + w && j < isCovered.length; j++) {
                        isCovered[j] = true;
                    }

                    unCoveredCount = 0;
                    i = Math.min(i + w, isCovered.length - 1);
                }
            } else {
                unCoveredCount = 0;
            }
        }


        return answer;
    }
}
