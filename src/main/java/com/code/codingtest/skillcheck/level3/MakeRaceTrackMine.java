package com.code.codingtest.skillcheck.level3;

public class MakeRaceTrackMine {
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

        System.out.println(new MakeRaceTrackMine().solution(board5));
    }

    int len;
    int answer = Integer.MAX_VALUE;

    //이렇게 짜도 통과는 함. 하지만 MakeRaceTrackDFS02 처럼 진행순서가 하우상좌로 바뀌면 실패케이스 발생
    public int solution(int[][] board) {
        len = board.length;

        dfs(board, 0, 0, null);
        return answer;
    }

    private void dfs(int[][] board, int row, int col, Moves prevMove) {
        if (row == len - 1 && col == len - 1) {
            answer = Math.min(answer, board[row][col]);
            return;
        }

        for (Moves move : Moves.values()) {
            int nextRow = 0;
            int nextCol = 0;
            try {
                nextRow = getValidateCoord(row + move.x);
                nextCol = getValidateCoord(col + move.y);
            } catch (Exception e) {
                continue;
            }

            if (nextRow == 0 && nextCol == 0) {
                return;
            }

            if (board[nextRow][nextCol] != 1) {
                if (prevMove == null || prevMove.category.equals(move.category)) {
                    if (board[nextRow][nextCol] == 0 || board[nextRow][nextCol] >= board[row][col] + 100) {
                        board[nextRow][nextCol] = board[row][col] + 100;
                        dfs(board, nextRow, nextCol, move);
                    }
                } else {
                    if (board[nextRow][nextCol] == 0 || board[nextRow][nextCol] >= board[row][col] + 600) {
                        board[nextRow][nextCol] = board[row][col] + 600;
                        dfs(board, nextRow, nextCol, move);
                    }
                }
            }
        }
    }

    private int getValidateCoord(int coord) throws Exception {
        if (coord < 0 || coord > len - 1) {
            throw new Exception();
        }

        return coord;
    }
}

enum Moves {
    RIGHT("WIDTH", 0, 1), DOWN("HEIGHT", 1, 0), LEFT("WIDTH", 0, -1), UP("HEIGHT", -1, 0);

    String category;
    int x;
    int y;

    Moves(String category, int x, int y) {
        this.category = category;
        this.x = x;
        this.y = y;
    }
}