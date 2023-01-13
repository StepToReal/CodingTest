package com.code.codingtest.skillcheck.level3;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class EditTable3 {
    public static void main(String[] args) {
        int n = 1000000;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        String result = new EditTable3().solution(n, k, cmd);
        System.out.println(result);
    }

    class Node {
        int pre;
        int curr;
        int next;

        Node(int pre, int curr, int next) {
            this.pre = pre;
            this.curr = curr;
            this.next = next;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
            sb.append("O");
        }

        next[n - 1] = - 1;

        for (String c : cmd) {
            if ("C".equals(c)) {
                Node node = new Node(pre[k], k, next[k]);
                stack.push(node);

                if (pre[k] != -1) next[pre[k]] = next[k];
                if (next[k] != -1) pre[next[k]] = pre[k];

                sb.setCharAt(k, 'X');

                if (next[k] != -1) k = next[k];
                else k = pre[k];
            } else if ("Z".equals(c)) {
                Node node = stack.pop();

                if (node.pre != -1) next[node.pre] = node.curr;
                if (node.next != -1) pre[node.next] = node.curr;
                sb.setCharAt(node.curr, 'O');
            } else {
                int move = Integer.parseInt(c.split(" ")[1]);

                if (c.startsWith("U")) {
                    while (move-- > 0) {
                        k = pre[k];
                    }
                } else {
                    while (move-- > 0) {
                        k = next[k];
                    }
                }
            }
        }

        return sb.toString();
    }
}
