package com.code.codingtest.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNodeImprove {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int n = 6;
        int[][] edge = {{1,2}, {5,1},{2,4},{4,6},{2,5},{3,5}};

        System.out.println(new FarthestNodeImprove().solution(n, edge));
    }

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        return bfs();
    }

    int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;

        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int adjustNode : graph.get(node)) {
                    if (!visited[adjustNode]) {
                        temp.add(adjustNode);
                        visited[adjustNode] = true;
                    }
                }
            }

            if (temp.isEmpty()) break;

            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }
}
