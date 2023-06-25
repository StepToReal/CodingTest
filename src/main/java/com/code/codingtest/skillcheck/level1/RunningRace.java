package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(new RunningRace().solution(players, callings)));
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int score = map.get(calling);
            String prevName = players[score - 1];

            map.replace(calling, score - 1);
            map.replace(prevName, map.get(prevName) + 1);

            String temp = players[score - 1];
            players[score - 1] = players[score];
            players[score] = temp;
        }

        return players;
    }
}
