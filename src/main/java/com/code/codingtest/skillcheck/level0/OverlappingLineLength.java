package com.code.codingtest.skillcheck.level0;

import java.sql.Array;
import java.util.*;

public class OverlappingLineLength {
    public static void main(String[] args) {
//        int[][] lines = {{0,1}, {2,5}, {3,9}};
        int[][] lines = {{0,5}, {3,9}, {1,10}};

        System.out.println(new OverlappingLineLength().solution(lines));
    }

    public int solution(int[][] lines) {
        List<Integer> totalLine = new ArrayList<>();
        Set<Integer> overlap = new HashSet<>();

        for (int i = 0; i < lines.length; i++) {
            int min = Math.min(lines[i][0], lines[i][1]);
            int max = Math.max(lines[i][0], lines[i][1]);

            for (int j = min; j < max; j++) {
                if (totalLine.contains(j)) {
                    overlap.add(j);
                } else {
                    totalLine.add(j);
                }
            }
        }

        return overlap.size();
    }
}
