package com.code.codingtest.dfsbfs;

import java.awt.*;
import java.util.*;

public class GameMapShortestDistanceSolve2 {
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

        System.out.println(new GameMapShortestDistanceSolve2().solution(maps));
    }

    // dfs와 동일한 동작방식을 bfs로 구성했을 뿐인데 효율성 테스트도 모두 통과함. 뭐가 다르지?
    // 음.. 단순히 생각하기에는 dfs는 물이 한 줄씩 흐르는 방식으로 통로를 정해놓고 해당 통로에 물을 한번씩 흘려보아 확인하는 방식이고
    // bfs는 물이 퍼지듯이 찾아들어가기 때문에 최단거리를 찾는데는 bfs가 적합한 것 같음.
    public int solution(int[][] maps) {
        // 시작 지점은 0,0
        // 도착 지점은 maps.length - 1, maps[0].length - 1
        // 도착 지점까지 갈 방법이 없으면 -1 return
        // 도착 지점까지 갈 수 있는 칸의 최소 값 return

        Queue<Point> queue = new LinkedList<>();
        boolean isFind = false;

        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == maps.length - 1 && point.y == maps[point.x].length - 1) {
                isFind = true;
                break;
            }

            if (point.x + 1 < maps.length && maps[point.x + 1][point.y] == 1) {
                queue.add(new Point(point.x + 1, point.y));
                maps[point.x + 1][point.y] = maps[point.x][point.y] + 1;
            }

            if (point.y + 1 < maps[point.x].length && maps[point.x][point.y + 1] == 1) {
                queue.add(new Point(point.x, point.y + 1));
                maps[point.x][point.y + 1] = maps[point.x][point.y] + 1;
            }

            if (point.x > 0 && maps[point.x - 1][point.y] == 1) {
                if (point.x - 1 == 0 && point.y == 0) {
                    continue;
                }

                queue.add(new Point(point.x - 1, point.y));
                maps[point.x - 1][point.y] = maps[point.x][point.y] + 1;
            }

            if (point.y > 0 && maps[point.x][point.y - 1] == 1) {
                if (point.x == 0 && point.y - 1 == 0) {
                    continue;
                }

                queue.add(new Point(point.x, point.y - 1));
                maps[point.x][point.y - 1] = maps[point.x][point.y] + 1;
            }
        }

        return isFind ? maps[maps.length - 1][maps[0].length - 1] : -1;
    }
}
