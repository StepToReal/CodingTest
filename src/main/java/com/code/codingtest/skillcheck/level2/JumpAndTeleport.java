package com.code.codingtest.skillcheck.level2;

//점프와 순간이동
public class JumpAndTeleport {
    public static void main(String[] args) {
        System.out.println(new JumpAndTeleport().solution(5000));
    }

    public int solution(int n) {
        int answer = 1;

        while (n != 1) {
            if (n % 2 != 0) {
                answer++;
            }

            n = n / 2;
        }

        return answer;
    }
}
