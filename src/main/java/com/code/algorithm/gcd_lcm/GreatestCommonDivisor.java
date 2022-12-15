package com.code.algorithm.gcd_lcm;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int a = 36;
        int b = 27;

        int divisor = gcd(a, b);
        System.out.println(divisor);

        divisor = gcd2(a, b);
        System.out.println(divisor);
    }

    private static int gcd2(int a, int b) {
        int n = -1;

        while (true) {
            n = a % b;

            if (n == 0) return b;

            a = b;
            b = n;
        }
    }

    public static int gcd(int a, int b) {
        int n = a % b;

        if (n == 0) {
            return b;
        }

        return gcd(b, n);
    }
}
