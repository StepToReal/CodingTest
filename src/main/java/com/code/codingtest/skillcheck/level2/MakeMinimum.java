package com.code.codingtest.skillcheck.level2;

import java.util.*;
import java.util.stream.Collectors;

public class MakeMinimum {

    public static void main(String[] args) {
        int[] a = {1,4,2};
        int[] b = {5,4,4};

        System.out.println(new MakeMinimum().solution(a, b));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[B.length - 1 - i];

            answer += a * b;
        }

        return answer;
    }
}
