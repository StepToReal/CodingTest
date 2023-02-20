package com.code.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking02 {
    static int n, m;
    static boolean[] visited;
    static int[] tempArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        tempArr = new int[n + 1];

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tempArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            tempArr[index] = i;
            backtracking(index + 1);
            visited[i] = false;
        }
    }
}
