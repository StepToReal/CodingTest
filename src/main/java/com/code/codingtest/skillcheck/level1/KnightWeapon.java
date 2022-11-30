package com.code.codingtest.skillcheck.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightWeapon {
    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        System.out.println(new KnightWeapon().solution(number, limit, power));

        int[] counts = new int[number + 1];

        //약수 구하는 다른 방법. 전체 약수를 한번에 구함.
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                counts[i * j]++;

                System.out.println("(" + i + ", " + j + ") " + Arrays.toString(counts));
            }
        }
    }

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int attack = getAttack(i);

            if (attack > limit) {
                attack = power;
            }

            answer += attack;
        }

        return answer;
    }

    private int getAttack(int n) {
        List<Integer> divisors = new ArrayList<>();
        int sqrt = (int)Math.sqrt(n);

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return sqrt * sqrt == n ? divisors.size() * 2 - 1 : divisors.size() * 2;
    }
}
