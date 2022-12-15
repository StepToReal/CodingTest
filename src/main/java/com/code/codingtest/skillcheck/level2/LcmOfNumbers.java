package com.code.codingtest.skillcheck.level2;

public class LcmOfNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        System.out.println(new LcmOfNumbers().solution(arr));
    }

    private int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = lcm(arr[i], arr[i + 1]);
        }

        return arr[arr.length - 1];
    }

    private int lcm(int a, int b) {
        int temp;

        if (b > a) {
            temp = a;
            a = b;
            b = temp;
        }

        int divisor = gcd(a, b);

        return (a * b) / divisor;
    }

    private int gcd(int a, int b) {
        int n = a % b;

        if (n == 0) {
            return b;
        }

        return gcd(b, n);
    }
}
