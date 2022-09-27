package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2_network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(new Problem2_network().solution(n, computers));
    }

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        List<List<Integer>> networks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> tempList = new ArrayList<>();
            visited = new boolean[n];

            dfs(i, computers, tempList);

            if (!tempList.isEmpty()) {
                Collections.sort(tempList);
            }

            if (networks.isEmpty()) {
                networks.add(tempList);
            } else {
                boolean isAdd = true;

                for (List<Integer> network : networks) {
                    if (network.containsAll(tempList)) {
                        isAdd = false;
                        break;
                    }
                }

                if (isAdd) {
                    networks.add(tempList);
                }
            }
        }

        return networks.size();
    }

    private void dfs(int index, int[][] computers, List<Integer> tempList) {
        if (!visited[index]) {
            visited[index] = true;
            tempList.add(index);

            for (int i = 0; i < computers.length; i++) {
                if (i != index && computers[index][i] == 1) {
                    dfs(i, computers, tempList);
                }
            }
        }
    }
}
