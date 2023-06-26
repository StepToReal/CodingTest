package com.code.codingtest.skillcheck.level1;

public class PaintWall {
    public static void main(String[] args) {

    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int endNo = -1;

        if (n == m) return answer + 1;

        for (int wallNo : section) {
            if (endNo != -1 && wallNo <= endNo) continue;

            endNo = wallNo + m - 1;
            answer++;
        }

        return answer;
    }
}
