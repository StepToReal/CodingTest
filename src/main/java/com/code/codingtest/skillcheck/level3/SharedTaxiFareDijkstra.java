package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class SharedTaxiFareDijkstra { //프로그래머스 - 합승 택시 요금
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(new SharedTaxiFareDijkstra().solution(n, s, a, b, fares));
    }

    List<Path> paths = new ArrayList<>();
    boolean[] visit;
    int[] dp;
    int[] stopoverNodes;
    int firstDestinationNode = 0;
    int secondDestinationNode = 0;

    /*
    속도가 나긴 나는데.. 최단 경로로 목적지를 하나 찾고 남은 목적지까지 dijkstra를 구해서 가는게 반례가 있는지 실패가 뜸
    추가로 런타임 에러도 발생.. 잘못된 접근 방법인듯 하다.
     */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Path>[] listArr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        stopoverNodes = new int[n + 1];

        for (int i = 1; i < listArr.length; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            listArr[fare[0]].add(new Path(fare[0], fare[1], fare[2]));
            listArr[fare[1]].add(new Path(fare[1], fare[0], fare[2]));
        }

        findFirstDestinationPath(listArr, s, a, b);
        Arrays.fill(visit, false);
        dijkstra(listArr, firstDestinationNode);

        int stopoverNode = secondDestinationNode;

        while (true) {
            if (stopoverNodes[stopoverNode] == firstDestinationNode) {
                int finalStopoverNode = stopoverNode;
                Path path = listArr[firstDestinationNode].stream().filter(p -> p.to == finalStopoverNode).findFirst().get();
                paths.add(path);
                break;
            } else {
                int from = stopoverNodes[stopoverNode];
                int to = stopoverNode;

                Path path = listArr[from].stream().filter(p -> p.to == to).findFirst().get();
                paths.add(path);

                stopoverNode = stopoverNodes[stopoverNode];
            }
        }

        return paths.stream().distinct().mapToInt(p -> p.fare).sum();
    }

    private void dijkstra(List<Path>[] listArr, int from) {
        Queue<Path> queue = new PriorityQueue<>();
        queue.add(new Path(from, from, 0));
        dp[from] = 0;

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            int to = path.to;

            if (visit[to]) continue;
            else visit[to] = true;

            for (Path next : listArr[to]) {
                if (dp[next.to] >= dp[to] + next.fare) {
                    dp[next.to] = dp[to] + next.fare;
                    stopoverNodes[next.to] = to;
                    queue.add(new Path(next.to, next.to, dp[next.to]));
                }
            }
        }
    }

    private void findFirstDestinationPath(List<Path>[] listArr, int s, int a, int b) {
        List<Path> list = listArr[s];
        Path minLengthsPath = list.stream().min(Comparator.comparing(p -> p.fare)).orElse(null);

        while (minLengthsPath != null) {
            visit[minLengthsPath.from] = true;
            paths.add(minLengthsPath);

            if (minLengthsPath.to == a || minLengthsPath.to == b) {
                firstDestinationNode = minLengthsPath.to == a ? a : b;
                secondDestinationNode = minLengthsPath.to == a ? b : a;
                break;
            }

            list = listArr[minLengthsPath.to];
            minLengthsPath = list.stream().filter(p -> !visit[p.to]).min(Comparator.comparing(p -> p.fare)).orElse(null);
        }
    }
}

class Path implements Comparable{
    int from;
    int to;
    int fare;

    public Path(int from, int to, int fare) {
        this.from = from;
        this.to = to;
        this.fare = fare;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(fare, ((Path)o).fare);
    }

    @Override
    public boolean equals(Object o) {
        Path p = (Path)o;
        return (from == p.from && to == p.to) || (from == p.to && to == p.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from + to, fare);
    }
}
