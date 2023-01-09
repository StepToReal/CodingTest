package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class RoadFindGame2 {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {4, 2}};

//        int[][] nodeinfo = {{5, 3}};

        int[][] result = new RoadFindGame2().solution(nodeinfo);
        System.out.println(Arrays.deepToString(result));
    }

    int[][] answer;
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        ArrayList<Node> list = new ArrayList<>();

        int no = 0;
        for (int[] node : nodeinfo) {
            list.add(new Node(++no, node[0], node[1], null, null));
        }
        Collections.sort(list);

        Node root = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }

        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);

        return answer;
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;
        }
    }

    private void preorder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
}

class Node implements Comparable<Node> {
    int num;
    int x;
    int y;

    Node left;
    Node right;

    Node(int num, int x, int y, Node left, Node right) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node node) {
        if (this.y == node.y) {
            return this.x - node.x;
        } else {
            return node.y - this.y;
        }
    }
}