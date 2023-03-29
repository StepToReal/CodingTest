package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class ReturnToArmy {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;

        int[] answer = new ReturnToArmy().solution(n, roads, sources, destination);

        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        boolean[] visited = new boolean[n + 1];
        int[] shortcut = new int[n + 1];
        Arrays.fill(shortcut, -1);
        Queue<Integer[]> queue = new LinkedList<>();

        Map<Integer, List<Integer>> nodes = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            nodes.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            nodes.get(road[0]).add(road[1]);
            nodes.get(road[1]).add(road[0]);
        }

        visited[destination] = true;
        queue.add(new Integer[] {destination, 0});

        while (!queue.isEmpty()) {
            Integer[] currNode = queue.poll();

            shortcut[currNode[0]] = currNode[1];

            for (int i = 0; i < nodes.get(currNode[0]).size(); i++) {
                Integer nextNodeNo = nodes.get(currNode[0]).get(i);

                if (visited[nextNodeNo]) continue;

                visited[nextNodeNo] = true;
                Integer[] nextArr = new Integer[]{nextNodeNo, currNode[1] + 1};
                queue.add(nextArr);
            }
        }


        for (int i = 0; i < sources.length; i++) {
            answer[i] = shortcut[sources[i]];
        }

        return answer;
    }
}
