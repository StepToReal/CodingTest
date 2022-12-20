package com.code.codingtest.skillcheck.level3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MakeRaceTrackBFS01 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}};

        int[][] board2 = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        int[][] board3 = {{0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        int[][] board4 = {{0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        int[][] board5 = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0},
        };

        System.out.println(new MakeRaceTrackBFS01().solution(board5));
    }

    TrackPoint[][] costs;
    int len;

    public int solution(int[][] board) {
        len = board.length;
        costs = new TrackPoint[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] != 1) {
                    costs[i][j] = new TrackPoint(i, j);
                }
            }
        }

        Queue<TrackPoint> queue = new LinkedList<>();
        TrackPoint start = costs[0][0];
        start.rowInputCost = 0;
        start.colInputCost = 0;

        queue.add(start);

        while (!queue.isEmpty()) {
            TrackPoint currentPoint = queue.poll();

            for (Moves moves : Moves.values()) {
                int nextX = currentPoint.x + moves.x;
                int nextY = currentPoint.y + moves.y;

                if (nextX < 0 || nextY < 0 || nextX > len - 1 || nextY > len - 1) {
                    continue;
                }

                if (costs[nextX][nextY] != null) {
                    TrackPoint nextPoint = costs[nextX][nextY];

                    if (moves.category.equals("WIDTH")) {
                        int cost = Math.min(currentPoint.rowInputCost + 100, currentPoint.colInputCost + 600);
                        if (nextPoint.rowInputCost > cost) {
                            nextPoint.rowInputCost = cost;
                            queue.add(nextPoint);
                        }
                    } else {
                        int cost = Math.min(currentPoint.rowInputCost + 600, currentPoint.colInputCost + 100);
                        if (nextPoint.colInputCost > cost) {
                            nextPoint.colInputCost = cost;
                            queue.add(nextPoint);
                        }
                    }
                }
            }
        }

        return Math.min(costs[len-1][len-1].rowInputCost, costs[len-1][len-1].colInputCost);
    }
}

class TrackPoint {
    int x;
    int y;
    int rowInputCost = 1000000000;
    int colInputCost = 1000000000;

    TrackPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}