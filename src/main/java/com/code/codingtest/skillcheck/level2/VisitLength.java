package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class VisitLength {
    public static void main(String[] args) {
        System.out.println(new VisitLength().solution("ULURRDLLU"));
    }

    public int solution(String dirs) {
        int answer = 0;
        Map<Point, List<Point>> map = new HashMap<>();
        Point p = new Point(0, 0);
        map.put(p, new ArrayList<>());

        for (char c : dirs.toCharArray()) {
            Point nextP = p.getNextPoint(c);

            if (nextP != null) {
                List<Point> points;

                if (map.containsKey(nextP)) {
                    points = map.get(nextP);
                } else {
                    points = new ArrayList<>();
                    map.put(nextP, points);
                }

                if (!map.get(p).contains(nextP)) {
                    answer++;
                    map.get(p).add(nextP);
                    points.add(p);
                }

                p = nextP;
            }
        }

        return answer;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point getNextPoint(char c) {
            int nextX = x;
            int nextY = y;

            switch (c) {
                case 'U' : nextY += 1; break;
                case 'D' : nextY -= 1; break;
                case 'L' : nextX -= 1; break;
                case 'R' : nextX += 1; break;
            }

            if (Math.abs(nextX) > 5 || Math.abs(nextY) > 5) {
                return null;
            } else {
                return new Point(nextX, nextY);
            }
        }

        public boolean equals(Object o) {
            Point target = (Point) o;
            return this.x == target.x && this.y == target.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
