package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.List;

//카카오 - 경주로 건설
public class MakeRaceTrack {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0},
                         {0,1,1,1,1,0},
                         {0,0,1,0,0,0},
                         {1,0,0,1,0,1},
                         {0,1,0,0,0,1},
                         {0,0,0,0,0,0}};

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

        int[][] board4 = {{0,0,0,0,0,0,0,1},
                          {0,0,0,0,0,0,0,0},
                          {0,0,0,0,0,1,0,0},
                          {0,0,0,0,1,0,0,0},
                          {0,0,0,1,0,0,0,1},
                          {0,0,1,0,0,0,1,0},
                          {0,1,0,0,0,1,0,0},
                          {1,0,0,0,0,0,0,0}};

        System.out.println(new MakeRaceTrack().solution(board4));
    }

    int length = 0;
    List<Integer> costs = new ArrayList<>();

    public int solution(int[][] board) {
        length = board.length;

        dfs(board, 0, 0, null);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("%10d", board[i][j]);
            }
            System.out.println();
        }

        return costs.stream().min(Integer::compare).get();
    }

    private void dfs(int[][] board, int x, int y, move prevMove) {
        if (x == length - 1 && y == x) {
            costs.add(board[x][y]);
            return;
        }

        for (move m : move.values()) {
            try {
                int a = getValidateCoord(x + m.getX());
                int b = getValidateCoord(y + m.getY());

                if ((a == 0 && b == 0) || board[a][b] == 1) {
                    continue;
                }

                if (board[a][b] == 0) {
                    if (prevMove == null || m.category.equals(prevMove.category)) {
                        board[a][b] = board[x][y] + 100;
                    } else {
                        board[a][b] = board[x][y] + 600;
                    }

                    dfs(board, a, b, m);
                    board[a][b] = 0;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    private int getValidateCoord(int i) throws Exception{
        if (i < 0 || i > length - 1) throw new Exception();
        else return i;
    }
}

enum move {
    LEFT("width", -1, 0), RIGHT("width",1, 0),
    UP("height",0, 1), DOWN("height",0, -1);

    String category;
    int x;
    int y;

    move(String category, int x, int y) {
        this.category = category;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
