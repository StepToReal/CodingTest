package com.code.codingtest.greedy;

import java.util.Arrays;

public class ConnectIslandImprove {
    public static void main(String[] args) {
        int n = 7;
        int[][] costs = {{2,3,7},{3,6,13},{3,5,23},{5,6,25},{0,1,29},{1,5,34},{1,2,35},{4,5,53},{0,4,75}};

        System.out.println(new ConnectIsland().solution(n, costs));
    }

    public int solution(int n, int[][] costs) {
        int sum = 0;
        int[] island = new int[n];

        for (int i = 0; i < n; i++) {
            island[i] = i;
        }

        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < costs.length; i++) {
            if (find(island, costs[i][0]) != find(island, costs[i][1])) {
                unit(island, costs[i][0], costs[i][1]);
                sum += costs[i][2];
            }
        }

        return sum;
    }

    private int find (int[] island, int x){
        if (island[x] == x)
            return x;
        return find(island, island[x]);
    }

    private void unit(int[] island, int x, int y) {
        int a = find(island, x);
        int b = find(island, y);

        island[a] = b;
    }
}
