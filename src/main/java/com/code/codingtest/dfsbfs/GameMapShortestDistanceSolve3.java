package com.code.codingtest.dfsbfs;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistanceSolve3 {
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

        int[][] maps3 = {{1,1,0,1,1,1,1}
                        ,{0,1,0,1,0,0,1}
                        ,{0,1,0,1,1,0,1}
                        ,{0,1,0,0,1,0,1}
                        ,{0,1,0,1,1,0,1}
                        ,{0,1,1,1,0,0,1}};

        System.out.println(new GameMapShortestDistanceSolve3().solution(maps));
    }

    //프로그래머스 답안 중 나와 구현 방식이 다른 가장 깔끔한 코드.
    //move를 사용하여 상하좌우로 가는 방식을 구현하면서 index 처리를 깔끔하게 한 것이 눈에 띈다.
    public int solution(int[][] maps) {
        int answer = -1;
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        maps[0][0] = 2;
        queue.add(new int[]{0, 0, 1}); //x, y, value

        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            if (coord[0] == maps.length - 1 && coord[1] == maps[0].length - 1) {
                answer = coord[2];
                break;
            }

            for (int i = 0; i < move.length; i++) {
                int x = coord[0] + move[i][0];
                int y = coord[1] + move[i][1]; //하, 우, 좌, 상 으로 한번씩 움직임

                if ((0 <= x && x < maps.length) && (0 <= y && y < maps[0].length) && maps[x][y] == 1) {
                    maps[x][y] = 2;
                    queue.add(new int[]{x, y, coord[2] + 1});
                }
            }
        }

        return answer;
    }
}
