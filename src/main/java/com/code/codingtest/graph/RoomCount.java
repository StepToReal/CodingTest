package com.code.codingtest.graph;

import java.sql.Array;
import java.util.*;
import java.util.List;

//v - e + f = 1 --> 1 - v + e = f
public class RoomCount {
    public static void main(String[] args) {
//        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        int[] arrows = {5,0,3,0,6,6,4,2,2,4,6,6,6,0,0,2,0,3,0,3};

        System.out.println(new RoomCount().solution(arrows));
    }

    public int solution(int[] arrows) {
        int answer = 0;

        Point currPoint = new Point(0,0);

        Map<Point, List<Point>> nodes = new HashMap<>();
        nodes.put(currPoint, new ArrayList<>());

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 교차점으로 생성되는 방을 구하기 위한 스케일업 
                Direction direction = Direction.valueOf(arrow);
                Point nextPoint = new Point(currPoint.getX() + direction.getX(), currPoint.getY() + direction.getY());

                if (!nodes.containsKey(nextPoint)) { // 지나간 적이 없는 포인트 이면 다음 포인트를 저장하고 현재 포인트 정보를 추가
                    nodes.put(nextPoint, makeNodeValue(currPoint));
                } else {
                    if (!nodes.get(nextPoint).contains(currPoint)) { // 지난친 적이 있는 포인트인데 새로운 간선이면 방 개수 추가
                        nodes.get(nextPoint).add(currPoint);
                        answer++;
                    }
                }
                nodes.get(currPoint).add(nextPoint);
                currPoint = nextPoint;
            }
        }

        return answer;
    }

    private List<Point> makeNodeValue(Point currPoint) {
        List<Point> list = new ArrayList<>();
        list.add(currPoint);
        return list;
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point)o;
            return x == p.getX() && y == p.getY();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

enum Direction {
    UP(0, 0, 1),
    LEFTUP(1, 1, 1),
    LEFT(2, 1, 0),
    LEFTDN(3, 1, -1),
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
