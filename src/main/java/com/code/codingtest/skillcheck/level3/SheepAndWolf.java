package com.code.codingtest.skillcheck.level3;

import com.sun.org.apache.xml.internal.utils.StylesheetPIHandler;
import org.omg.CORBA.Current;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.*;

public class SheepAndWolf {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        System.out.println(new SheepAndWolf().solution(info, edges));
    }

    Map<Integer, Node> nodeMap = new HashMap<>();
//    List<Node> visitableNodes = new ArrayList<>();
    int[] sheepAndWolf = {0, 0};
    int max = 1;

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            Node node = new Node(i, info[i]);
            nodeMap.put(i, node);
        }

        for (int i = 0; i < edges.length; i++) {
            int no = edges[i][0];
            int child = edges[i][1];

            nodeMap.get(no).putChild(nodeMap.get(child));
        }

        bt(0, new ArrayList<Node>());

        return max;
    }

    private void bt(int nodeNo, List<Node> nextNodes) {
        Node currNode = nodeMap.get(nodeNo);
        sheepAndWolf[currNode.type]++;

        if (sheepAndWolf[0] == sheepAndWolf[1]) {
            return;
        }
        max = Math.max(sheepAndWolf[0], max);

        List<Node> visitableNodes = new ArrayList<>(nextNodes);
        visitableNodes.remove(currNode);
        visitableNodes.addAll(currNode.children);

        for (int i = 0; i < visitableNodes.size(); i++) {
            Node nextNode = visitableNodes.get(i);

            bt(nextNode.no, visitableNodes);
            sheepAndWolf[nextNode.type]--;
        }
    }

    class Node {
        int no;
        int type;
        List<Node> children = new ArrayList<>();

        Node(int no, int type) {
            this.no = no;
            this.type = type;
        }

        void putChild(Node node) {
            children.add(node);
        }
    }
}
