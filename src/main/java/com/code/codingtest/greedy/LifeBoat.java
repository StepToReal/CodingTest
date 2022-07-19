package com.code.codingtest.greedy;

import java.util.Arrays;

public class LifeBoat {
    public static void main(String[] args) {
        int[] people = {100,500,500,900,950};
        int limit = 1000;

        System.out.println(new LifeBoat().solution(people, limit));
    }

    public int solution (int[] people, int limit) {
        Arrays.sort(people);
        int boatCnt = 0;
        int minIndex = 0;

        for (int i = people.length - 1; i >= 0 && i >= minIndex; i--) {
            if (i != minIndex && people[i] + people[minIndex] <= limit) {
                minIndex++;
                boatCnt++;
            } else {
                boatCnt++;
            }
        }

        return boatCnt;
    }
}
