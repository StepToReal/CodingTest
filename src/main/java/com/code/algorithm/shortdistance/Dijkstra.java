package com.code.algorithm.shortdistance;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
//        int[][] maps = {{1,2,2}, {1,4,1}, {1,3,5}, {2,3,3}, {2,4,2},
//                {3,4,3}, {3,5,1}, {4,5,1}, {5,6,2}, {3,6,5}};

        int[][] maps = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int n = 6;

        solution(n, maps);
    }

    static List<Node>[] list;
    static int[] dp;

    static String[] path;
    static boolean[] check;

    // BFS 와 유사함. 가중치를 추가 계산해야 하기 때문에 우선순위 큐를 이용.
    // weight 가 가벼운 순으로 우선순위 부여
    static void solution(int n, int maps[][]) {
        check = new boolean[n + 1];
        dp = new int[n + 1];
        path = new String[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] map : maps) {
            list[map[0]].add(new Node(map[1], map[2]));
            list[map[1]].add(new Node(map[0], map[2]));
        }

        dijkstra(6);

        for (int num : dp) {
            System.out.println(num + " ");
        }
    }

    static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        q.add(new Node(start, 0));
        dp[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int to = node.to;

            if (check[to]) continue;
            else check[to] = true;

            for (Node next : list[to]) {
                if (dp[next.to] >= dp[to] + next.weight) {
                    dp[next.to] = dp[to] + next.weight;
                    path[next.to] = to + "-";
                    q.add(new Node(next.to, dp[next.to]));
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(path));
    }
}

class Node implements Comparable<Node> {
    int to;
    int weight;

    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return Integer.compare(this.weight, n.weight);
    }

    @Override
    public String toString() {
        return "(" + to + ", " + weight + ")";
    }
}
