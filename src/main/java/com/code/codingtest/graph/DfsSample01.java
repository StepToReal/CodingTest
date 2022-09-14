package com.code.codingtest.graph;

import com.code.algorithm.dfsbfs.DfsExample01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DfsSample01 {
    List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) {
        new DfsSample01().solution();
    }

    public void solution() {
        for (int i = 0; i <= 9; i++) {
            map.add(new ArrayList<>());
        }

        map.get(1).add(2);
        map.get(2).addAll(Arrays.asList(3, 4, 5));
        map.get(3).add(6);
        map.get(4).addAll(Arrays.asList(7, 8));
        map.get(7).add(9);

        dfs(1);
    }

    private void dfs(int i) {
        System.out.println(i);

        Iterator<Integer> it = map.get(i).iterator();

        while (it.hasNext()) {
            dfs(it.next());
        }
    }
}
