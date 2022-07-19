package com.code.codingtest.greedy;

public class TrainingWearImprove {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,2,4};
        int[] reserve = {2,3,4,5};

        System.out.println(new TrainingWearImprove().solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];
        int answer = n;

        for (int l : lost)
            people[l]--;
        for (int r : reserve) 
            people[r]++;

        for (int i = 1; i < people.length - 1; i++) {
            if (people[i] == -1) {
                if (people[i - 1] == 1) {
                    people[i]++;
                    people[i-1]--;
                } else if (people[i + 1] == 1) {
                    people[i]++;
                    people[i + 1]--;
                } else 
                    answer--;
            }
        }

        return answer;
    }
}
