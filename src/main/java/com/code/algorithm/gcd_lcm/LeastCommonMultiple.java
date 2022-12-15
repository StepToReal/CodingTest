package com.code.algorithm.gcd_lcm;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        int a = 15;
        int b = 10;

        int multiple = lcm(a, b);

        System.out.println(multiple);
    }

    private static int lcm(int a, int b) {
        int divisor = GreatestCommonDivisor.gcd(a, b);

        return (a * b) / divisor;
    }
}
