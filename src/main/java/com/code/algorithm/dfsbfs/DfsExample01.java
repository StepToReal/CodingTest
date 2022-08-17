package com.code.algorithm.dfsbfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DfsExample01 {
    public static void main(String[] args) {
        DfsExampleGraph dg = new DfsExampleGraph(11);

        dg.addEdge(1, 2);
        dg.addEdge(1, 5);
        dg.addEdge(1, 9);

        dg.addEdge(2, 3);

        dg.addEdge(3, 4);

        dg.addEdge(5, 6);
        dg.addEdge(5, 8);

        dg.addEdge(6, 7);

        dg.addEdge(9, 10);

        dg.dfs(1);
    }
}

class DfsExampleGraph {
    private int v;
    private LinkedList<Integer>[] adj;

    DfsExampleGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        //인접 리스트 초기화
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[this.v];

        //v를 시작하는 노드로 dfsUtil 호출
        dfsUtil(v, visited);
    }

    private void dfsUtil(int v, boolean visited[]) {
        //현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.println(v + " ");

        //방문한 노드와 인접한 모든 노드를 가지고 온다.
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            //방무하지 않은 노드면 해당 노드를 시작 노드로 다시 dfsUtil 재귀 호출
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }
}
