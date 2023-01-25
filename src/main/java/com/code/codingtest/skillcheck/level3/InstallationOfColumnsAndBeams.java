package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class InstallationOfColumnsAndBeams {
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

        System.out.println(Arrays.deepToString(new InstallationOfColumnsAndBeams().solution(n, build_frame)));
    }

    int[][] columns;
    int[][] beams;

    public int[][] solution(int n, int[][] build_frame) {
        //build_frame[2] -> 0 기둥, 1 보
        //build_frame[3] -> 0 삭제, 1 설치
        n += 1;
        columns = new int[n][n];
        beams = new int[n][n];
        int count = 0;

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];

            if (build[3] == 1) { // 설치
                if (type == 0) { // 기둥 설치
                    if (isInstallColumn(x, y)) {
                        columns[x][y] = 1;
                        count++;
                    }
                } else { // 보 설치
                    if (isInstallBeams(x, y)) {
                        beams[x][y] = 1;
                        count++;
                    }
                }
            } else { // 삭제
                if (type == 0) { // 기둥 삭제
                    columns[x][y] = 0;

                    if (isNoProblem(n)) {
                        count--;
                    } else {
                        columns[x][y] = 1;
                    }
                } else { // 보 삭제
                    beams[x][y] = 0;

                    if (isNoProblem(n)) {
                        count--;
                    } else {
                        beams[x][y] = 1;
                    }
                }
            }
        }

        int[][] answer = new int[count][3];
        int answerIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (columns[i][j] == 1) {
                    answer[answerIndex][0] = i;
                    answer[answerIndex][1] = j;
                    answer[answerIndex++][2] = 0;
                }
                if (beams[i][j] == 1) {
                    answer[answerIndex][0] = i;
                    answer[answerIndex][1] = j;
                    answer[answerIndex++][2] = 1;
                }
            }
        }

        return answer;
    }

    private boolean isInstallBeams(int x, int y) {
        if (y > 0 && columns[x][y - 1] == 1 || columns[x + 1][y - 1] == 1) { // 한쪽 끝에 기둥이 있으면 설치 가능
            return true;
        } else if (x > 0 && beams[x - 1][y] == 1 && beams[x + 1][y] == 1) { // 양 끝에 보가 있으면 설치 가능
            return true;
        } else {
            return false;
        }
    }

    private boolean isInstallColumn(int x, int y) {
        if (y == 0) { // 설치 위치가 바닥이면 설치 가능
            return true;
        } else if (y > 0 && columns[x][y - 1] == 1) { //바로 아래 기둥이 있으면 설치 가능
            return true;
        } else if (x > 0 && beams[x - 1][y] == 1 || beams[x][y] == 1) { // 보의 양 끝위치면 설치 가능
            return true;
        } else {
            return false;
        }
    }

    private boolean isNoProblem(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (columns[i][j] == 1 && !isInstallColumn(i, j)) {
                    return false;
                } else if (beams[i][j] == 1 && !isInstallBeams(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
