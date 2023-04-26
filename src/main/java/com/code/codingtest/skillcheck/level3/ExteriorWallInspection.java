package com.code.codingtest.skillcheck.level3;

import java.util.*;
import java.util.stream.Collectors;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        int n = 12;
//        int[] weak = {1, 3, 4, 9, 10};
//        int[] dist = {3, 5, 7};

        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        int min = new ExteriorWallInspection().solution(n, weak, dist);
        System.out.println(min);
    }

    Map<Integer, Boolean> visitMap = new HashMap<>();
    int minNum = Integer.MAX_VALUE;
    int n;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        List<Path> pathList = new ArrayList<>();
        Arrays.sort(dist);

        for (int k : weak) {
            visitMap.put(k, false);
            pathList.add(new Path(k, k, 0));
        }

        for (int i = 0; i < weak.length - 1; i++) {
            for (int j = i + 1; j < weak.length; j++) {
                int leftLength = weak[j] - weak[i];
                int rightLength = (weak[i] + n) - weak[j];

                pathList.add(new Path(weak[i], weak[j], leftLength));
                pathList.add(new Path(weak[j], weak[i], rightLength));
            }
        }

        pathList.removeIf(i -> i.length > dist[dist.length - 1]);
        pathList.sort((i1, i2) -> i2.length - i1.length);

        dfs(dist, 0, pathList, 0);

        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }

    private void dfs(int[] dist, int distIndex, List<Path> pathList, int count) {
        if (isAllVisit()) {
            minNum = Math.min(minNum, count);
            return;
        }

        for (int i = distIndex; i < dist.length; i++) {
            int len = dist[i];

            for (Path path : pathList) {
                if (path.isVisit || checkVisit(visitMap, path)) continue;

                if (len >= path.length) {
                    path.isVisit = true;
                    editVisitMap(path, true);

                    dfs(dist, distIndex + 1, pathList, count + 1);

                    if (minNum == 1) return;

                    path.isVisit = false;
                    editVisitMap(path, false);
                }
            }
        }
    }

    private boolean checkVisit(Map<Integer, Boolean> visitMap, Path path) {
        for (int i = path.start; i <= path.end; i++) {
            if (visitMap.containsKey(i) && visitMap.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void editVisitMap(Path path, boolean visit) {
        for (Map.Entry<Integer, Boolean> entry : visitMap.entrySet()) {
            if (path.start <= path.end) {
                if (path.start <= entry.getKey() && entry.getKey() <= path.end) {
                    entry.setValue(visit);
                }
            } else {
                if ((path.start <= entry.getKey() && entry.getKey() < n) ||
                        (entry.getKey() <= path.end && entry.getKey() >= 0)) {
                    entry.setValue(visit);
                }
            }
        }
    }

    private boolean isAllVisit() {
        for (Map.Entry<Integer, Boolean> entry : visitMap.entrySet()) {
            if (!entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    class Path {
        int start;
        int end;
        int length;
        boolean isVisit = false;

        public Path(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}
