package com.code.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertAtOperator {

    static int numCount;
    static int[] numArr;
    static String[] operArr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        readInput();

        calc(0, numArr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void calc(int depth, int value) {
        if (depth == numCount - 1) {
            min = Math.min(value, min);
            max = Math.max(value, max);
            return;
        }

        int nextNum = numArr[depth + 1];

        for (int i = 0; i < operArr.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            int result = value;

            switch (operArr[i]) {
                case "+":
                    result += nextNum;
                    break;
                case "-":
                    result -= nextNum;
                    break;
                case "*":
                    result *= nextNum;
                    break;
                case "/":
                    result = Math.abs(value) / nextNum;
                    if (value < 0) result = -1 * result;
                    break;
            }

            calc(depth + 1, result);
            visit[i] = false;
        }
    }

    private static void readInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                if (i == 0) {
                    numCount = Integer.parseInt(st.nextToken());
                    numArr = new int[numCount];
                    operArr = new String[numCount - 1];
                    visit = new boolean[numCount - 1];

                } else if (i == 1) {
                    for (int j = 0; j < numCount; j++) {
                        numArr[j] = Integer.parseInt(st.nextToken());
                    }
                } else {
                    int operIndex = 0;
                    for (int j = 0; j < 4; j++) {
                        int operCount = Integer.parseInt(st.nextToken());

                        for (int k = 0; k < operCount; k++) {
                            if (j == 0) operArr[operIndex++] = "+";
                            else if (j == 1) operArr[operIndex++] = "-";
                            else if (j == 2) operArr[operIndex++] = "*";
                            else operArr[operIndex++] = "/";
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
