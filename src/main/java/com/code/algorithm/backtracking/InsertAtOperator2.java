package com.code.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertAtOperator2 {

    static int numCount;
    static int[] numArr;
    static int[] operArr = new int[4];
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

        for (int i = 0; i < operArr.length; i++) {
            if (operArr[i] == 0) continue;

            operArr[i]--;

            switch (i) {
                case 0:
                    calc(depth + 1, value + numArr[depth + 1]); break;
                case 1:
                    calc(depth + 1, value - numArr[depth + 1]); break;
                case 2:
                    calc(depth + 1, value * numArr[depth + 1]); break;
                case 3:
                    calc(depth + 1, value / numArr[depth + 1]); break;
            }

            operArr[i]++;
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

                } else if (i == 1) {
                    for (int j = 0; j < numCount; j++) {
                        numArr[j] = Integer.parseInt(st.nextToken());
                    }
                } else {
                    for (int j = 0; j < 4; j++) {
                        operArr[j] = Integer.parseInt(st.nextToken());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
