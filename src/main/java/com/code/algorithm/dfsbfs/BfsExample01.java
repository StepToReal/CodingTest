package com.code.algorithm.dfsbfs;

import java.util.Iterator;
import java.util.LinkedList;

public class BfsExample01 {
    public static void main(String[] args) {
        BfsExampleGraph dg = new BfsExampleGraph(11);

        dg.addEdge(1, 2);
        dg.addEdge(1, 5);
        dg.addEdge(1, 9);

        dg.addEdge(2, 3);

        dg.addEdge(3, 4);

        dg.addEdge(5, 6);
        dg.addEdge(5, 8);

        dg.addEdge(6, 7);

        dg.addEdge(9, 10);

        dg.bfs(1);
    }
}

class BfsExampleGraph {
    private int v;
    private LinkedList<Integer>[] adj;

    BfsExampleGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[this.v];//방문여부 확인용 변수
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            //방문한 노드를 큐에서 추출하고 값을 출력
            s = queue.poll();
            System.out.println(s + " ");

            //방문한 노드와 인접한 모든 노드를 가지고 온다.
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();

                //방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
