package com.code.codingtest.graph;

import java.util.*;

public class Ranking03 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(new Ranking03().solution(n, results));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> graph = new ArrayList<>();
        int[][] io = new int[n][2];
        boolean[] visited;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            graph.get(result[0] - 1).add(result[1] - 1);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(graph, io, visited, i, i);
        }

        for (int i = 0; i < n; i++) {
            if (io[i][0] + io[i][1] == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public void dfs (List<List<Integer>> graph, int[][] io, boolean[] visited, int i, int base) {
        visited[i] = true;

        if (i != base) {
            io[base][1] += 1;
            io[i][0] += 1;
        }

        for (int g : graph.get(i)) {
            if (!visited[g]) {
                dfs(graph, io, visited, g, base);
            }
        }
    }
}
