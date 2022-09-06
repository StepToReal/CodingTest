package com.code.codingtest.graph;

import java.util.*;

public class farthestNode {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int n = 6;
        int[][] edge = {{1,2}, {5,1},{2,4},{4,6},{2,5},{3,5}};

        System.out.println(new farthestNode().solution(n, edge));
    }

    public int solution(int n, int[][] edge) {
        Graph graph = new Graph(n);

        for (int[] edgeItem : edge) {
            graph.addEdge(edgeItem[0], edgeItem[1]);
        }

        graph.bfs();

        return graph.getFarthestNodeCount();
    }
}

class Graph {
    private LinkedList<int[]>[] adjustNodes;
    private int totalNodeNum;
    private int[] lengthArr;
    private boolean[] visited;

    Graph(int totalNodeNum) {
        this.totalNodeNum = totalNodeNum + 1;
        adjustNodes = new LinkedList[this.totalNodeNum];
        lengthArr = new int[this.totalNodeNum];
        visited = new boolean[this.totalNodeNum];

        for (int i = 0; i < this.totalNodeNum; i++) {
            adjustNodes[i] = new LinkedList<>();
        }
    }

    public void addEdge(int node, int linkedNode) {
        adjustNodes[node].add(new int[] {linkedNode, 0});
        adjustNodes[linkedNode].add(new int[] {node, 0});
    }

    public void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        visited[1] = true;
        for (int[] nodeNum : adjustNodes[1]) {
            queue.add(new int[] {nodeNum[0], 1});
            visited[nodeNum[0]] = true;
        }

        while (!queue.isEmpty()) {
            int[] nodeArr = queue.poll();
            int nodeNum = nodeArr[0];
            int length = nodeArr[1];

            visited[nodeNum] = true;
            lengthArr[nodeNum] = length;

            for (int[] linkedNode : adjustNodes[nodeNum]) {
                int linkedNodeNum = linkedNode[0];

                if (!visited[linkedNodeNum]) {
                    queue.add(new int[] {linkedNodeNum, length + 1});
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
