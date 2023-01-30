package com.code.codingtest.skillcheck.level3;

import java.util.*;
import java.util.regex.Pattern;

public class UnbrokenBuilding {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        System.out.println(new UnbrokenBuilding().solution(board, skill));
    }

    public int solution(int[][] board, int[][] skill) {
        //skill[n][0] = type, type 1 = attack, type2 = heal
        int answer = board.length * board[0].length;
        Map<Integer, Node> map = new HashMap<>();

        for (int[] s : skill) {
            int type = s[0];
            int damage = type == 1 ? -1 * s[5] : s[5];

            for (int i = s[1]; i <= s[3]; i++) {
                for (int j = s[2]; j <= s[4]; j++) {
                    Integer key = Objects.hash(i, j);

                    if (map.containsKey(key)) {
                        map.get(key).damage += damage;
                    } else {
                        map.put(key, new Node(i, j, damage));
                    }
                }
            }
        }

        for (Node node : map.values()) {
            int x = node.x;
            int y = node.y;
            int damage = node.damage;

            if (board[x][y] + damage <= 0) {
                answer--;
            }
        }

        return answer;
    }

    class Node {
        int x, y;
        int damage;

        Node(int x, int y, int damage) {
            this.x = x;
            this.y = y;
            this.damage = damage;
        }
    }
}
