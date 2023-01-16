package com.code.codingtest.skillcheck.level1;

import java.util.*;
import java.util.stream.Collectors;

public class FailPercent {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = {4,4,4,4};
        System.out.println(Arrays.toString(new FailPercent().solution(N, stages)));

        double a = (double)3371/3330;
        double b = (double)3371/3330;

        System.out.println(a);
        System.out.println(b);

        System.out.println(Double.doubleToRawLongBits(a));
        System.out.println(Double.doubleToRawLongBits(b));

    }

    class Stage implements Comparable<Stage> {
        int stageNo;
        int reachNum;
        int failNum;
        double failRate;

        Stage(int stageNo) {
            this.stageNo = stageNo;
        }

        public void setFailRate() {
            this.failRate = (double)failNum / reachNum;
        }

        public int compareTo(Stage o) {
            if (failRate > o.failRate) {
                return -1;
            } else if (failRate < o.failRate) {
                return 1;
            } else {
                return Integer.compare(stageNo, o.stageNo);
            }

//            if (Double.compare(o.failRate, failRate) == 0) return Integer.compare(stageNo, o.stageNo);
//            else return Double.compare(o.failRate, failRate);
        }
    }

    public int[] solution(int N, int[] stages) {
        int reachUser = stages.length;
        Map<Integer, Integer> stageFailMap = new HashMap<>();
        List<Stage> list = new ArrayList<>();

        for (int stage : stages) {
            stageFailMap.put(stage, stageFailMap.getOrDefault(stage, 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            Stage stage = new Stage(i + 1);
            stage.reachNum = reachUser;
            stage.failNum = stageFailMap.getOrDefault(i + 1, 0);
            stage.setFailRate();

            reachUser -= stageFailMap.getOrDefault(i + 1, 0);

            list.add(stage);
        }

        return list.stream().sorted().mapToInt(stage -> stage.stageNo).toArray();
    }
}
