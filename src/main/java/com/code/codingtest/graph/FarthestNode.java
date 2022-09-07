package com.code.codingtest.graph;

import java.util.*;

public class FarthestNode {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int n = 6;
        int[][] edge = {{1,2}, {5,1},{2,4},{4,6},{2,5},{3,5}};

        System.out.println(new FarthestNode().solution(n, edge));
    }

    public int solution(int n, int[][] edge) {
        Graph graph = new Graph(n);

        for (int[] edgeItem : edge) {
            graph.addEdge(edgeItem);
        }

        graph.bfs();

        return graph.getFarthestNodeCount();
    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> adjustNodes;
    private int totalNodeNum;
    private int[] lengthArr;
    private int[] prevIndexArr;
    private boolean[] visited;

    Graph(int totalNodeNum) {
        this.totalNodeNum = totalNodeNum + 1;
        adjustNodes = new ArrayList<>();
        lengthArr = new int[this.totalNodeNum];
        prevIndexArr = new int[this.totalNodeNum];
        visited = new boolean[this.totalNodeNum];

        for (int i = 0; i < this.totalNodeNum; i++) {
            adjustNodes.add(new ArrayList<>());
        }
    }

    public void addEdge(int[] edge) {
        adjustNodes.get(edge[0]).add(edge[1]);
        adjustNodes.get(edge[1]).add(edge[0]);
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int adjustNode : adjustNodes.get(1)) {
            queue.add(adjustNode);
            prevIndexArr[adjustNode] = 1;
        }
        visited[1] = true;

        while (!queue.isEmpty()) {
            int nodeNum = queue.poll();
            int prevIndex = prevIndexArr[nodeNum];

            visited[nodeNum] = true;
            lengthArr[nodeNum] = lengthArr[prevIndex] + 1;

            for (int adjustNode : adjustNodes.get(nodeNum)) {
                if (!visited[adjustNode] && prevIndexArr[adjustNode] == 0) {
                    queue.add(adjustNode);
                    prevIndexArr[adjustNode] = nodeNum; //
                }
            }
        }
    }

    public int getFarthestNodeCount() {
        int cnt = 0;
        Arrays.sort(lengthArr);

        int max = lengthArr[totalNodeNum - 1];
        for (int i = totalNodeNum - 1; i >= 0; i--) {
            if (max == lengthArr[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
