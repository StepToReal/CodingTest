package com.code.codingtest.skillcheck.level1;

public class Cola {
    public static void main(String[] args) {
        System.out.println(new Cola().solution(3, 2, 9));
        System.out.println(new Cola().solution(2, 1, 20));
        System.out.println(new Cola().solution(3, 1, 20));
    }

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int newCola = (n / a) * b;
            answer += newCola;
            n = newCola + n % a;
        }

        return answer;
    }
}
