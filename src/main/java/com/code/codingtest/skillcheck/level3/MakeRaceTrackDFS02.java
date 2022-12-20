package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;

//카카오 - 경주로 건설
public class MakeRaceTrackDFS02 {
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

        System.out.println(new MakeRaceTrackDFS02().solution(board));
    }

    int length = 0;
    boolean[][] visited;
    int[][] minCost;
    int answer;

    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    //이 풀이는 진행 순서가 바뀌면 실패하는 케이스가 발생한다.
    //우하좌상 이동은 전부 통과 하지만 하우상좌 이동은 실패 케이스가 발생한다. --> 반쪽짜리 해답.
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        length = board.length;
        visited = new boolean[length][length];
        minCost = new int[length][length];

        for (int[] mc : minCost) {
            Arrays.fill(mc, Integer.MAX_VALUE);
        }

        dfs(board, 0, 0, 0, -1);

        return answer;
    }

    private void dfs(int[][] board, int i, int j, int cost, int dir) {
        if (i == length - 1 && j == length - 1) {
            answer = Math.min(answer, cost);
            return;
        }

        if (cost > answer)
            return;
        if (minCost[i][j] < cost)
            return;

        for (int x = 0; x < 4; x++) {
            int nextRow = i + dirRow[x];
            int nextCol = j + dirCol[x];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < length && nextCol < length &&
                    board[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;

                if (dir == -1 || dir == (x % 2)) {
                    if (minCost[nextRow][nextCol] >= cost + 100) {
                        minCost[nextRow][nextCol] = cost + 100;
                        dfs(board, nextRow, nextCol, cost + 100, x % 2);
                    }
                } else {
                    if (minCost[nextRow][nextCol] >= cost + 600) {
                        minCost[nextRow][nextCol] = cost + 600;
                        dfs(board, nextRow, nextCol, cost + 600, x % 2);
                    }
                }

                visited[nextRow][nextCol] = false;
            }
        }
    }
}