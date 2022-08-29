package com.code.codingtest.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FillThePuzzlePieces {
    int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        System.out.println(new FillThePuzzlePieces().solution(game_board, table));
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        //game board 에서 빈칸 찾기
        List<int[][]> boardEmptySpace = getSpace(game_board, 0);

        //table 에서 퍼즐 찾기
        List<int[][]> tableFillSpace = getSpace(table, 1);

        //board 빈칸들에 table item 회전하며 대입시키기

        return answer;
    }

    private List<int[][]> getSpace(int[][] board, int num) {
        List<int[][]> resultList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == num) {
                    board[i][j] = -1;
                    int[][] puzzle = new int[board.length][board.length];
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] coord = queue.poll();
                        puzzle[coord[0]][coord[1]] = 1;

                        for (int k = 0; k < move.length; k++) {
                            if (coord[0] + move[k][0] >= board.length || coord[0] + move[k][0] < 0 ||
                                    coord[1] + move[k][1] >= board[0].length || coord[1] + move[k][1] < 0) {
                                continue;
                            }

                            int x = coord[0] + move[k][0];
                            int y = coord[1] + move[k][1];

                            if (board[x][y] == num) {
                                queue.add(new int[]{x, y});
                                board[x][y] = -1;
                            }
                        }
                    }

                    resultList.add(puzzle);
                }
            }
        }

        return resultList;
    }
}
