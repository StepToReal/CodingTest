package com.code.codingtest.skillcheck.level3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EditTable2 {
    public static void main(String[] args) {
        int n = 1000000;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        new EditTable2().solution(n, k, cmd);
        System.out.println();
    }

    class Node {
        Integer value;
        Integer index;

        Node(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        long start = System.currentTimeMillis();
        System.out.println("start list init");

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        System.out.println("end list init : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("start command parsing");

        for (String c : cmd) {
            if ("C".equals(c)) {
                stack.push(new Node(list.get(k), k));
                list.remove(k);

                if (k == list.size()) {
                    k--;
                }
            } else if ("Z".equals(c)) {
                Node node = stack.pop();
                list.add(node.index, node.value);
                if (node.index <= k) k++;
            } else {
                int move = Integer.parseInt(c.split(" ")[1]);

                if (c.startsWith("D")) {
                    k += move;
                } else {
                    k -= move;
                }
            }
        }
        System.out.println("end command parsing : " + (System.currentTimeMillis() - start));

        ArrayList<Integer> removedList = new ArrayList<>(stack.stream().map(node -> node.value).collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (removedList.contains(i)) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }

        return sb.toString();
    }
}
