package com.code.codingtest.dfsbfs;

import java.util.*;

public class PickupItem {
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
//        int[][] rectangle = {{1,1,7,4},{3,2,5,5}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        System.out.println(new PickupItem().solution(rectangle, characterX, characterY, itemX, itemY));
    }

    //* 참고 rectangle 객체를 만들어서 푸는 방법도 있다.
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        Set<Coord> coordSet = new HashSet<>(); // Set 과 equals 구현으로 중복 좌표 제거

        // 인접한 테두리 확인을 위해 rectangle 사이즈를 2배로 늘린다.
        for (int i = 0; i < rectangle.length; i++) {
            for (int xIndex = rectangle[i][0] * 2; xIndex <= rectangle[i][2] * 2; xIndex++) { // x좌표값 증가시키며 bottom, top 좌표 add
                coordSet.add(new Coord(xIndex, rectangle[i][1] * 2)); //bottom coordinate
                coordSet.add(new Coord(xIndex, rectangle[i][3] * 2)); //top coordinate
            }

            for (int yIndex = rectangle[i][1] * 2; yIndex <= rectangle[i][3] * 2; yIndex++) { // y좌표값 증가시키며 left, right 좌표 add
                coordSet.add(new Coord(rectangle[i][0] * 2, yIndex)); //left coordinate
                coordSet.add(new Coord(rectangle[i][2] * 2, yIndex)); //right coordinate
            }
        }

        for (int i = 0; i < rectangle.length; i++) { // 각 rectangle 확인하여 사각형 내부 좌표 제거 -> 이후에 테두리만 남음
            for (int xIndex = rectangle[i][0] * 2 + 1; xIndex < rectangle[i][2] * 2; xIndex++) {
                for (int yIndex = rectangle[i][1] * 2 + 1; yIndex < rectangle[i][3] * 2; yIndex++) {
                    Coord coord = new Coord(xIndex, yIndex);

                    if (coordSet.contains(coord)) {
                        coordSet.remove(coord);
                    }
                }
            }
        }

        Coord characterCoord = new Coord(characterX * 2, characterY * 2);
        Coord itemCoord = new Coord(itemX * 2, itemY * 2);

        Queue<Coord> queue = new LinkedList<>();
        int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        queue.add(characterCoord);

        while (!queue.isEmpty()) {
            Coord c = queue.poll();

            if (c.equals(itemCoord)) {
                answer = c.moveCount;
                break;
            }

            for (int i = 0; i < move.length; i++) {
                Coord moveC = new Coord(c.x + move[i][0], c.y + move[i][1]);

                if (coordSet.contains(moveC)) {
                    moveC.moveCount = c.moveCount + 1;
                    queue.add(moveC);
                }
            }

            coordSet.remove(c);
        }

        return answer / 2;
    }
}

class Coord {
    int x = 0;
    int y = 0;

    int moveCount = 0;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coord) {
            Coord coord = (Coord) o;
            return this.x == coord.x && this.y == coord.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x * 1000 + y;
    }
}