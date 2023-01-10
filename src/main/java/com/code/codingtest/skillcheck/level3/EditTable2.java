package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class EditTable2 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.get(2));

        System.out.println(new EditTable2().solution(n, k, cmd));
    }

    public String solution(int n, int k, String[] cmd) {
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (String c : cmd) {
            if (c.startsWith("D") || c.startsWith("U")) {
                int move = Integer.parseInt(c.split(" ")[1]);

                if (c.startsWith("D")) {
                    k += move;
                } else {
                    k -= move;
                }
            } else if ("C".equals(c)) {
                stack.push(list.get(k));
                list.remove(k);

                if (k == list.size()) {
                    k--;
                }
            } else if ("Z".equals(c)) {
                int removed = stack.pop();
                int last = list.get(list.size() - 1);

                if (removed > last) {
                    list.add(removed);
                } else if (removed < list.get(0)) {
                    list.add(0, removed);
                    k++;
                } else {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i) < removed && removed < list.get(i + 1)) {
                            list.add(i + 1, removed);

                            if (i + 1 <= k) {
                                k++;
                            }
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (list.contains(i)) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }
}
