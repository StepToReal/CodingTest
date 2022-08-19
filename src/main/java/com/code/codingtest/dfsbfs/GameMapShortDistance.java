package com.code.codingtest.dfsbfs;

import java.util.*;

public class GameMapShortDistance {
    int rowLength;
    int colLength;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}
                      , {1, 0, 1, 0, 1}
                      , {1, 0, 1, 1, 1}
                      , {1, 1, 1, 0, 1}
                      , {0, 0, 0, 0, 1}};

        int[][] maps2 = {{1, 0, 0, 0, 0}
                       , {1, 1, 1, 1, 1}
                       , {1, 1, 0, 1, 1}
                       , {1, 1, 1, 0, 1}
                       , {1, 0, 1, 0, 1}
                       , {1, 1, 1, 0, 1}};

        System.out.println(new GameMapShortDistance().solution(maps2));
    }

    public int solution(int[][] maps) {
        // 시작 지점은 0,0
        // 도착 지점은 maps.length - 1, maps[0].length - 1
        // 도착 지점까지 갈 방법이 없으면 -1 return
        // 도착 지점까지 갈 수 있는 칸의 최소 값 return

        rowLength = maps.length;
        colLength = maps[0].length;

        dfs(maps, 0, 0);

        return maps[rowLength - 1][colLength - 1] == 1 ? -1 : maps[rowLength - 1][colLength - 1];
    }

    private void dfs(int[][] maps, int row, int col) {
        if (row == rowLength - 1 && col == colLength - 1) {
            return;
        }

        if (row != rowLength - 1 && maps[row + 1][col] != 0 && (maps[row + 1][col] == 1 || maps[row + 1][col] >= maps[row][col] + 1)) {
            maps[row + 1][col] = maps[row][col] + 1;
            dfs(maps, row + 1, col);
        }

        if (col != colLength - 1 && maps[row][col + 1] != 0 && (maps[row][col + 1] == 1 || maps[row][col + 1] >= maps[row][col] + 1)) {
            maps[row][col + 1] = maps[row][col] + 1;
            dfs(maps, row, col + 1);
        }

        if (col != 0 && col - 1 != 0 && maps[row][col - 1] != 0 && (maps[row][col - 1] == 1 || maps[row][col - 1] >= maps[row][col] + 1)) {
            maps[row][col - 1] = maps[row][col] + 1;
            dfs(maps, row, col - 1);
        }

        if (row != 0 && row - 1 != 0 && maps[row-1][col] != 0 && (maps[row -1][col] == 1 || maps[row - 1][col] >= maps[row][col] + 1)) {
            maps[row - 1][col] = maps[row][col] + 1;
            dfs (maps, row - 1, col);
        }
    }
}
