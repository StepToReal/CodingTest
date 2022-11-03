package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class SharedTaxiFare { //프로그래머스 - 합승 택시 요금
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(new SharedTaxiFare().solution(n, s, a, b, fares));
    }
    boolean[] visit;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int[] fare : fares) {
            map.get(fare[0]).put(fare[1], fare[2]);
            map.get(fare[1]).put(fare[0], fare[2]);
        }

        List<List<Integer>> aPaths = new ArrayList<>();
        List<List<Integer>> bPaths = new ArrayList<>();

        visit = new boolean[n + 1];
        dfs(map, s, a, new ArrayList<>(), aPaths);

        visit = new boolean[n + 1];
        dfs(map, s, b, new ArrayList<>(), bPaths);

        // s -> a, s -> b 의 모든 경로를 구하는 방법까지 했음
        // 두 경로들을 비교하여 최소값이 나오는 로직이 구현 되어야 함.

        for (List<Integer> aPath : aPaths) {
            for (List<Integer> bPath : bPaths) {

            }
        }

        return 0;
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> map, int s, int a, List<Integer> path, List<List<Integer>> paths) {
        if (s == a) {
            path.add(s);
            paths.add(new ArrayList<>(path));
            return;
        }

        if (!visit[s]) {
            visit[s] = true;
            path.add(s);

            for (Map.Entry<Integer, Integer> node : map.get(s).entrySet()) {
                if (!visit[node.getKey()]) {
                    int n = node.getKey();
                    dfs(map, n, a, path, paths);
                    visit[n] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
