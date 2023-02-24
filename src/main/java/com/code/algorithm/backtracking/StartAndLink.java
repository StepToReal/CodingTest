package com.code.algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StartAndLink {
    static int n;
    static int[] groupA;
    static int[] groupB;
    static int[][] board;
    static int[] tempArr = new int[2];
    static int minValue = Integer.MAX_VALUE;
    static int groupASum = 0;
    static int groupBSum = 0;

    public static void main(String[] args) {
        readInput();

        getMinimumGap(0, 0);

        System.out.println(minValue);
    }

    private static void getMinimumGap(int at, int depth) {
        if (depth == n / 2) {
            int groupBIndex = 0;
            Arrays.fill(groupB, -1);

            for (int i = 0; i < n; i++) {
                boolean isInGroupA = false;

                for (int j = 0; j < groupA.length; j++) {
                    if (i == groupA[j]) {
                        isInGroupA = true;
                        break;
                    }
                }

                if (!isInGroupA) groupB[groupBIndex++] = i;
            }

            groupASum = 0;
            groupBSum = 0;

            getTeamStatus("A", groupA, 0, 0);
            getTeamStatus("B", groupB, 0, 0);

            minValue = Math.min(minValue, Math.abs(groupASum - groupBSum));
            return;
        }

        for (int i = at; i < n; i++) {
            if (depth == 0 && i >= 1) {
                break;
            }

            groupA[depth] = i;
            getMinimumGap(i + 1, depth + 1);
        }
    }

    private static void getTeamStatus(String groupName, int[] group, int at, int depth) {
        if (depth == 2) {
            int i = tempArr[0];
            int j = tempArr[1];

            if (groupName.equals("A")) {
                groupASum += board[i][j] + board[j][i];
            } else {
                groupBSum += board[i][j] + board[j][i];
            }

            return;
        }

        for (int i = at; i < group.length; i++) {
            tempArr[depth] = group[i];
            getTeamStatus(groupName, group, i + 1, depth + 1);
        }
    }

    private static void readInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            groupA = new int[n / 2];
            groupB = new int[n / 2];
            board = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
