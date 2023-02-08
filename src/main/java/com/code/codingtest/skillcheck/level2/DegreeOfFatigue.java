package com.code.codingtest.skillcheck.level2;

public class DegreeOfFatigue {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.println(new DegreeOfFatigue().solution(k, dungeons));
    }

    int answer = 0;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
