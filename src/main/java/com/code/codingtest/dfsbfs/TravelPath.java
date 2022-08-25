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

    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        String start = "ICN";

        Map<String, List<String>> ticketMap = new HashMap<>();

        for (String[] ticket : tickets) {
            if (ticketMap.keySet().contains(ticket[0])) {
                ticketMap.get(ticket[0]).add(ticket[1]);
            } else {
                List<String> destinationList = new ArrayList<>();
                destinationList.add(ticket[1]);

                ticketMap.put(ticket[0], destinationList);
            }
        }

        for (Map.Entry<String, List<String>> entry : ticketMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for (Map.Entry<String, List<String>> entry : ticketMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                List<String> nextDestinationList = ticketMap.get(entry.getValue().get(i));

                if (nextDestinationList.contains(entry.getKey())) {

                }
            }
        }

        dfs(start, ticketMap, answer);

        return answer.toArray(new String[0]);
    }

    private void dfs(String start, Map<String, List<String>> ticketMap, List<String> answer) {
        answer.add(start);

        if (!ticketMap.containsKey(start)) {
            return;
        }

        List<String> destinations = ticketMap.get(start);

        for (int i = 0; i < destinations.size(); i++) {
            String destination = destinations.get(i);

            if (!destination.equals("000")) {
                destinations.set(i, "000");
                dfs(destination, ticketMap, answer);
            }
        }
    }
}
