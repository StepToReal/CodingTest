package com.code.codingtest.graph;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RoomCount {
    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(new RoomCount().solution(arrows));
    }

    public int solution(int[] arrows) {
        int answer = 0;

        Point prevPoint = new Point(0,0);

        List<Point> pointList = new ArrayList<>();
        pointList.add(prevPoint);

        for (int arrow : arrows) {
            Direction direction = Direction.valueOf(arrow);
            prevPoint = new Point(prevPoint.x + direction.getX(), prevPoint.y + direction.getY());
            pointList.add(prevPoint);
        }

        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                if (i == j) {
                    continue;
                } else {
                    Point p1 = pointList.get(i);
                    Point p2 = pointList.get(j);

                    if (p1.x == p2.x && p1.y == p2.y) {
                        System.out.println(p1.x + ", " + p1.y);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}

enum Direction {
    UP(0, 0, 1),
    LEFTUP(1, 1, 1),
    LEFT(2, 1, 0),
    LEFTDN(3, -1, -1),
    DOWN(4, 0, -1),
    RIGHTDN(5, -1, -1),
    RIGHT(6, -1, 0),
    RIGHTUP(7, -1, 1);

    int no;
    int x;
    int y;

    Direction(int no, int x, int y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }

    public int getNo() {
        return no;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Direction valueOf(int no) {
        for (Direction d : Direction.values()) {
            if (d.no == no) {
                return d;
            }
        }

        return null;
    }
}
