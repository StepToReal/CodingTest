package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class RoadFindGame {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

//        int[][] nodeinfo = {{5, 3}};

        int[][] result = new RoadFindGame().solution(nodeinfo);
        System.out.println(Arrays.deepToString(result));
    }

    boolean[] visit;
    int[][] answer;
    int index = 0;

    public int[][] solution(int[][] nodeinfo) {
        visit = new boolean[nodeinfo.length + 1];
        answer = new int[2][nodeinfo.length];
        Map<Integer, List<RoadNode>> depthMap = getDepthMap(nodeinfo);
        int rootNo = depthMap.keySet().stream().findFirst().get();

        preorder(depthMap.get(rootNo).get(0));
        index = 0;
        postorder(depthMap.get(rootNo).get(0));

        return answer;
    }

    private TreeMap<Integer, List<RoadNode>> getDepthMap(int[][] nodeinfo) {
        TreeMap<Integer, List<RoadNode>> result = new TreeMap<>((n1, n2) -> Integer.compare(n2, n1));

        int no = 1;
        for (int[] node : nodeinfo) {
            if (result.containsKey(node[1])) {
                result.get(node[1]).add(new RoadNode(no, node[0], node[1]));
            } else {
                List<RoadNode> list = new ArrayList<>();
                list.add(new RoadNode(no, node[0], node[1]));
                result.put(node[1], list);
            }
            no++;
        }

        combineNode(result);

        return result;
    }

    private void combineNode(TreeMap<Integer, List<RoadNode>> result) {
        List<RoadNode> prevNodeList = new ArrayList<>();

        for (Map.Entry<Integer, List<RoadNode>> nodeEntry : result.entrySet()) {
            List<RoadNode> nodeList = nodeEntry.getValue();

            if (prevNodeList.isEmpty()) {
                nodeList.get(0).setLeftLimit(-1);
                nodeList.get(0).setRightLimit(100001);
                prevNodeList.addAll(nodeList);
                continue;
            }

            for (RoadNode currentNode : nodeList) {
                for (RoadNode parentNode : prevNodeList) {
                    if (currentNode.getX() < parentNode.getX() && currentNode.getX() > parentNode.getLeftLimit()) {
                        parentNode.left = currentNode;
                        currentNode.parent = parentNode;
                        currentNode.setLeftLimit(parentNode.getLeftLimit());
                        currentNode.setRightLimit(parentNode.getX());
                        break;
                    } else if (currentNode.getX() > parentNode.getX() && currentNode.getX() < parentNode.getRightLimit()) {
                        parentNode.right = currentNode;
                        currentNode.parent = parentNode;
                        currentNode.setLeftLimit(parentNode.getX());
                        currentNode.setRightLimit(parentNode.getRightLimit());
                        break;
                    }
                }
            }

            prevNodeList = nodeList;
        }
    }

    private void postorder(RoadNode node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }

        if ((node.left == null || visit[node.left.getNo()]) &&
                (node.right == null || visit[node.right.getNo()])) {
            answer[1][index++] = node.getNo();
            visit[node.getNo()] = true;
        }
    }

    private void preorder(RoadNode node) {
        answer[0][index++] = node.getNo();

        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }

    }
}

class RoadNode {
    private int no;
    private int x;
    private int y;

    RoadNode left;
    RoadNode right;
    RoadNode parent;

    private int leftLimit;
    private int rightLimit;

    public RoadNode(int no, int x, int y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }

    public int getNo() {
        return no;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public void setLeftLimit(int leftLimit) {
        this.leftLimit = leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public void setRightLimit(int rightLimit) {
        this.rightLimit = rightLimit;
    }
}
