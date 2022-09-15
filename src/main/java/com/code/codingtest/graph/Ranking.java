package com.code.codingtest.graph;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(new Ranking().solution(n, results));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        List<List<Integer>> winList = new ArrayList<>();
        List<List<Integer>> loseList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }

        for (int[] result : results) {
            winList.get(result[0]).add(result[1]);
            loseList.get(result[1]).add(result[0]);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> tempList = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];

            dfs(i, i, winList, tempList, visited);
            winList.set(i, tempList);

            tempList = new ArrayList<>();
            visited = new boolean[n + 1];

            dfs(i, i, loseList, tempList, visited);
            loseList.set(i, tempList);
        }

        for (int i = 1; i <= n; i++) {
            if (winList.get(i).size() + loseList.get(i).size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int index, int initVal, List<List<Integer>> list, List<Integer> tempList, boolean[] visited) {
        if (index != initVal) {
            tempList.add(index);
        }

        visited[index] = true;

        Iterator<Integer> it = list.get(index).iterator();

        while (it.hasNext()) {
            int nextValue = it.next();

            if (!visited[nextValue])
                dfs(nextValue, initVal, list, tempList, visited);
        }
    }
}
