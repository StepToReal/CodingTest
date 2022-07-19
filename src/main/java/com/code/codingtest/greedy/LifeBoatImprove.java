package com.code.codingtest.greedy;

import java.util.Arrays;

public class LifeBoatImprove {
    public static void main(String[] args) {
        int[] people = {100,500,500,900,950};
        int limit = 1000;

        System.out.println(new LifeBoat().solution(people, limit));
    }

    public int solution (int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;

        for (; i < j; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
        }

        return people.length - i;
    }
}
