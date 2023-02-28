package com.code.codingtest.skillcheck.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CardBunch {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(new CardBunch().solution(cards1, cards2, goal));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));

        for (String g : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(g)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(g)) {
                queue2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
