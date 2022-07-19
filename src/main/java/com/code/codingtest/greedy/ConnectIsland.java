package com.code.codingtest.greedy;

import java.util.*;
import java.util.Map.Entry;

public class ConnectIsland {
    public static void main(String[] args) {
        int n = 7;
        int[][] costs = {{2,3,7},{3,6,13},{3,5,23},{5,6,25},{0,1,29},{1,5,34},{1,2,35},{4,5,53},{0,4,75}};

        System.out.println(new ConnectIsland().solution(n, costs));
    }

    public int solution(int n, int[][] costs) {
        ArrayList<Line> Linelist = new ArrayList<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < costs.length; i++) {
            Line line = new Line(costs[i][0], costs[i][1], costs[i][2]);
            Linelist.add(line);

            if (!nodeMap.containsKey(costs[i][0])) {
                nodeMap.put(costs[i][0], new Node(costs[i][0]));
            }
            if (!nodeMap.containsKey(costs[i][1])) {
                nodeMap.put(costs[i][1], new Node(costs[i][1]));
            }
        }

        Collections.sort(Linelist);

        int selectLineCnt = 0;

        for (int i = 0; i < Linelist.size(); i++) {
            if (selectLineCnt < nodeMap.size() - 1) {
                Line l = Linelist.get(i);
                Node n1 = nodeMap.get(l.nodeNum1);
                Node n2 = nodeMap.get(l.nodeNum2);

                if(n1.rootNodeNum != n2.rootNodeNum) {
                    sum += l.cost;
                    changeRootNodeNum(nodeMap, n1.rootNodeNum, n2.rootNodeNum, Math.min(n1.nodeNum, n2.nodeNum));
                    selectLineCnt++;
                }                
            } else {
                break;
            }
        }

        return sum;
    }

    private void changeRootNodeNum(HashMap<Integer, Node> nodeMap, int n1Root, int n2Root, int minRoot) {
        for (Entry<Integer, Node> e : nodeMap.entrySet()) {
            if (e.getValue().rootNodeNum == n1Root || e.getValue().rootNodeNum == n2Root) {
                e.getValue().rootNodeNum = minRoot;
            }
        }
    }
}

class Line implements Comparable<Line> {

    int nodeNum1;
    int nodeNum2;
    int cost;

    public Line(int n1, int n2, int c) {
        nodeNum1 = n1;
        nodeNum2 = n2;
        cost = c;
    }

    @Override
    public int compareTo(Line o) {
        return cost - o.cost;
    }
}

class Node {
    int nodeNum;
    int rootNodeNum;
    
    public Node(int nodeNum) {
        this.nodeNum = nodeNum;
        rootNodeNum = nodeNum;
    }
}
