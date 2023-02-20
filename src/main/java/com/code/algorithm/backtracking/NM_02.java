package com.code.algorithm.backtracking;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NM_02 {

    static int n, m;
    static int[] tempArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tempArr = new int[n + 1];

        backtracking(1,0);

        System.out.println(sb.toString());
    }

    private static void backtracking(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tempArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            tempArr[depth] = i;
            backtracking(i + 1, depth + 1);
        }
    }
}
