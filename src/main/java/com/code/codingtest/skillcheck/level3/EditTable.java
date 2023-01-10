package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Function;

public class EditTable {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        System.out.println(new EditTable().solution(n, k, cmd));
    }

    public String solution(int n, int k, String[] cmd) {
        int[] rows = new int[n];
        Stack<Integer> deleteRows = new Stack<>();

        Arrays.fill(rows, 1);

        for (String c : cmd) {
            if (c.startsWith("D") || c.startsWith("U")) {
                String[] moves = c.split(" ");

                if (moves[0].equals("D")) {
                    k += getMove(rows, k, moves[1], i-> i);
                } else {
                    k -= getMove(rows, k, moves[1], i -> -i);
                }
            } else if ("C".equals(c)) {
                deleteRows.add(k);
                rows[k] = -1;

                int afterUsable = getAfterUsable(rows, k);

                if (afterUsable == -1) {
                    k = getBeforeUsable(rows, k);
                } else {
                    k = afterUsable;
                }
            } else if ("Z".equals(c)) {
                int i = deleteRows.pop();
                rows[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (rows[i] == 1) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }

    private int getBeforeUsable(int[] rows, int k) {
        for (int i = k - 1; i >= 0; i--) {
            if (rows[i] != -1) {
                return i;
            }
        }

        return -1;
    }

    private int getAfterUsable(int[] rows, int k) {
        for (int i = k; i < rows.length; i++) {
            if (rows[i] != -1) {
                return i;
            }
        }

        return -1;
    }

    private int getMove(int[] rows, int k, String move, Function<Integer, Integer> f) {
        int result = 0;
        int moveNum = Integer.parseInt(move);
        for (int i = 1; i <= moveNum; i++) {
            result++;

            if (rows[k + f.apply(i)] == -1) {
                moveNum++;
            }
        }

        return result;
    }
}
