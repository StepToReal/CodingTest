package com.code.codingtest.dfsbfs;

import java.util.*;

public class TravelPath {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "A"}};
        //[ICN, A, B, ICN] - 현재 return 값
        //[ICN, B, ICN, A] 가 나와야 함. A에서 B로 가는 티켓은 없다.
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(new TravelPath().solution(tickets)));
    }

    private static void printA(int a) {
        System.out.println(a);
    }

    boolean[] visited;
    ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    private void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1); //++c 를 하면 안됨
                                                                                // ++c는 변수값이 호출한 재귀 함수에서도 증가함.
                                                                                // c+1는 호출된 다음 함수에서만 값이 증가하고 현재 재귀함수에서는 증가하지 않음.
                visited[i] = false;
            }
        }
    }
}
