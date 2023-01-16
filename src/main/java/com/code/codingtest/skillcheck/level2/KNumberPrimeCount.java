package com.code.codingtest.skillcheck.level2;

public class KNumberPrimeCount {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(new KNumberPrimeCount().solution(n, k));
        String test = Integer.toString(n, k);
        System.out.println(test);
    }

    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }

        String[] element = sb.toString().split("0");

        for (String e : element) {
            if (e.isEmpty()) continue;

            if (isPrime(Long.parseLong(e))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(Long value) {
        if (value < 2L) return false;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }

        return true;
    }
}
