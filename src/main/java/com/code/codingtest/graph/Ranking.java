package com.code.codingtest.graph;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(new Ranking().solution(n, results));
    }

    List<List<Integer>> winList = new ArrayList<>();
    List<List<Integer>> loseList = new ArrayList<>();

    boolean[] visited;

    //https://jehwanyoo.net/2022/02/08/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%9C%EC%9C%84/
    // 처리 방식은 맞는데 중복코드를 제거해야 하고, 성능을 개선 해야 함 (메모리 부족 실패 떳음)
    public int solution(int n, int[][] results) {
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }

        for (int i = 0; i < results.length; i++) {
            winList.get(results[i][0]).add(results[i][1]);
            loseList.get(results[i][1]).add(results[i][0]);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> tempList = new ArrayList<>();
            winDfs(i, tempList);

            for (int temp : tempList) {
                if (temp != i && !winList.get(i).contains(temp)) {
                    winList.get(i).add(temp);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> tempList = new ArrayList<>();
            loseDfs(i, tempList);

            for (int temp : tempList) {
                if (temp != i && !loseList.get(i).contains(temp)) {
                    loseList.get(i).add(temp);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (winList.get(i).size() + loseList.get(i).size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private void winDfs(int index, List<Integer> tempList) {
        tempList.add(index);

        Iterator<Integer> it = winList.get(index).iterator();

        while (it.hasNext()) {
            winDfs(it.next(), tempList);
        }
    }

    private void loseDfs(int index, List<Integer> tempList) {
        tempList.add(index);

        Iterator<Integer> it = loseList.get(index).iterator();

        while (it.hasNext()) {
            loseDfs(it.next(), tempList);
        }
    }
}
