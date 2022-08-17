package com.code.algorithm.dfsbfs;

import java.util.ArrayList;

public class DeptFirstSearchAdjacentList {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        
        g.put(1, 4);
        g.put(1, 3);
        g.put(1, 2);
        g.put(2, 3);
        g.put(2, 4);
        g.put(3, 4);

        g.printGraphToAdjList();

        System.out.println();
        System.out.print("search 1 : ");
        g.dfs(1);

        System.out.println();
        System.out.print("search 2 : ");
        g.clearVisitArr();
        g.dfs(2);

        System.out.println();
        System.out.print("search 3 : ");
        g.clearVisitArr();
        g.dfs(3);

        System.out.println();
        System.out.print("search 4 : ");
        g.clearVisitArr();
        g.dfs(4);
    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> dfsGraph;
    private boolean[] visitArr;

    public Graph(int nodeNum) {
        dfsGraph = new ArrayList<>();

        for (int i = 0; i < nodeNum + 1; i++) {
            dfsGraph.add(new ArrayList<Integer>());
        }

        visitArr = new boolean[nodeNum + 1];
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return dfsGraph;
    }

    public ArrayList<Integer> getNode (int i) {
        return dfsGraph.get(i);
    }

    public void put(int x, int y) {
        dfsGraph.get(x).add(y);
        dfsGraph.get(y).add(x);
    }

    public void putSingle(int x, int y) {
        dfsGraph.get(x).add(y);
    }

    public void printGraphToAdjList() {
        for (int i = 1; i < dfsGraph.size(); i++) {
            System.out.println("정점 " + i + "의 인접리스트.");

            for (int j = 0; j < dfsGraph.get(i).size(); j++) {
                System.out.print(" -> " + dfsGraph.get(i).get(j));
            }

            System.out.println();
        }
    }

    public void clearVisitArr() {
        for (int i = 0; i < visitArr.length; i++) {
            visitArr[i] = false;
        }
    }

    public void dfs (int index) {
        visitArr[index] = true;
        System.out.print(index + " ");

        for (int i : dfsGraph.get(index)) {
            if (visitArr[i] == false) {
                dfs(i);
            }
        }
    }
}
