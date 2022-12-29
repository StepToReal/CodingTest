package com.code.codingtest.skillcheck.level1;

public class FoodFight {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};

        System.out.println(new FoodFight().solution2(food));
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int foodCnt = food[i] / 2;

            for (int j = 0; j < foodCnt; j++) {
                sb.append(i);
            }
        }

        sb.append("0");

        for (int i = sb.length() - 2; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }

        return sb.toString();
    }

    public String solution2(int[] food) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.insert(0, i).append(i);
            }
        }

        return sb.toString();
    }
}
