package com.code.codingtest.skillcheck.level3;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;

public class SharedTaxiFare { //프로그래머스 - 합승 택시 요금
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(new SharedTaxiFare().solution(n, s, a, b, fares));
    }

    boolean[] visit;
    List<List<Fare>> faresList = new ArrayList<>();

    // 틀린 방법은 아닌거 같은데.. 효율성 통과를 못함.
    public int solution(int n, int s, int a, int b, int[][] fares) {
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            faresList.add(new ArrayList<>()); //todo 이런걸 한번에 초기화 할 수 있는건 없을까?
        }

        for (int[] fare : fares) {
            faresList.get(fare[0]).add(new Fare(fare[0], fare[1], fare[2]));
            faresList.get(fare[1]).add(new Fare(fare[1], fare[0], fare[2]));
        }

        List<List<Fare>> aPath = new ArrayList<>();
        dfs(s, a, aPath, new ArrayList<>());

        List<List<Fare>> bPath = new ArrayList<>();
        dfs(s, b, bPath, new ArrayList<>());

        List<Integer> sums = new ArrayList<>();

        for (List<Fare> aFares : aPath) {
            for (List<Fare> bFares : bPath) {
                int sum = 0;

                sum += aFares.stream().mapToInt(f -> f.fare).sum() +
                        bFares.stream().mapToInt(f -> f.fare).sum();

                for (int i = 0; i < Math.min(aFares.size(), bFares.size()); i++) {
                    if (aFares.get(i).equals(bFares.get(i))) {
                        sum -= aFares.get(i).fare;
                    }
                }

                sums.add(sum);
            }
        }

        return sums.stream().min(Integer::compare).orElse(0);
    }

    private void dfs(int start, int a, List<List<Fare>> aPath, List<Fare> temp) {
        if (start == a) {
            aPath.add(new ArrayList<>(temp));
            return;
        }

        visit[start] = true;

        for (Fare f : faresList.get(start)) {
            if (!visit[f.endNode]) {
                temp.add(f);
                dfs(f.endNode, a, aPath, temp);
                visit[f.endNode] = false;
                temp.remove(f);
            }
        }
    }
}

class Fare {
    int startNode;
    int endNode;
    int fare;

    public Fare(int startNode, int endNode, int fare) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fare) {
            Fare target = (Fare)o;
            return this.startNode == target.startNode && this.endNode == target.endNode;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startNode, endNode, fare);
    }
}
