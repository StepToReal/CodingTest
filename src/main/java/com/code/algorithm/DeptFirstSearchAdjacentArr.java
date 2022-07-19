package com.code.algorithm;

public class DeptFirstSearchAdjacentArr {
    public static void main(String[] args) {
        GraphArr g = new GraphArr(4);
        
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

class GraphArr {
    private int nodeNum;
    private int[][] dfsGraph;
    private boolean[] visitArr;

    public GraphArr(int nodeNum) {
        this.nodeNum = nodeNum;
        dfsGraph = new int[nodeNum + 1][nodeNum + 1];
        visitArr = new boolean[nodeNum + 1];
    }

    public int[][] getGraph() {
        return dfsGraph;
    }

    public int[] getNode (int i) {
        return dfsGraph[i];
    }

    public void put(int x, int y) {
        dfsGraph[x][y] = dfsGraph[y][x] = 1;
    }

    public void putSingle(int x, int y) {
        dfsGraph[x][y] = 1;
    }

    public void printGraphToAdjList() {
        for (int i = 0; i < dfsGraph.length; i++) {
            for (int j = 0; j < dfsGraph[i].length; j++) {
                System.out.print(" " + dfsGraph[i][j]);
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

        for (int i = 1; i <= nodeNum; i++) {
            if (dfsGraph[index][i] == 1 && visitArr[i] == false) {
                dfs(i);
            }
        }
    }
}
