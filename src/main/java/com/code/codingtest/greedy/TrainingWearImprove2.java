package com.code.codingtest.greedy;

import java.util.HashSet;

public class TrainingWearImprove2 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,2,4};
        int[] reserve = {2,3,4,5};

        System.out.println(new TrainingWearImprove().solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        HashSet<Integer> ko = new HashSet<>();

        for (int k : reserve) {
            ko.add(k);
        }

        for (int i = 0; i < lost.length; i++) {
            if (ko.contains(lost[i])) {
                answer++;
                ko.remove(lost[i]);
                lost[i] = -1;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (ko.contains(lost[i] - 1)) {
                answer++;
                ko.remove(lost[i]-1);
            } else if (ko.contains(lost[i] + 1)) {
                answer++;
                ko.remove(lost[i]+1);
            }
        }

        return answer;
    }
}
