package com.code.codingtest.skillcheck.level0;

import java.util.ArrayList;
import java.util.List;

public class FiniteDecimalConfirm {
    public static void main(String[] args) {
        System.out.println(new FiniteDecimalConfirm().solution(11, 22));
    }

    public int solution(int a, int b) {
        int lcd = getLcd(a, b);
        return isFinite(b / lcd) ? 1 : 2;
    }

    boolean isFinite(int num) {
        int cnt = 0;

        if (num == 1 || num == 2 || num == 5) {
            return true;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                cnt++;

                if (i % 2 != 0 && i % 5 != 0) {
                    return false;
                }
            }
        }

        return cnt != 0;
    }

    int getLcd(int a, int b) {
        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b % a == 0) {
            return a;
        }

        return getLcd(b % a, a);
    }
}
