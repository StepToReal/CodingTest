package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class InstallationOfColumnsAndBeams {
    public static void main(String[] args) {
        int n = 5;
//        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

        System.out.println(Arrays.deepToString(new InstallationOfColumnsAndBeams().solution(n, build_frame)));
    }

    public int[][] solution(int n, int[][] build_frame) {
        //build_frame[2] -> 0 기둥, 1 보
        //build_frame[3] -> 0 삭제, 1 설치
        n += 1;
        int[][] columns = new int[n][n];
        int[][] beams = new int[n][n];

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int type = build[2];

            if (build[3] == 1) { // 설치
                if (type == 0) { // 기둥 설치
                    if (y == 0) {
                        columns[x][y] = 1;
                    } else if (columns[x][y - 1] == 1) {
                        columns[x][y] = 1;
                    } else if (beams[x][y] == 1 || beams[x - 1][y] == 1) {
                        columns[x][y] = 1;
                    }
                } else { // 보 설치
                    if (columns[x][y - 1] == 1 || columns[x + 1][y - 1] == 1) {
                        beams[x][y] = 1;
                    } else if (beams[x - 1][y] == 1 && beams[x + 1][y] == 1) {
                        beams[x][y] = 1;
                    }
                }
            } else { // 삭제
                if (type == 0) { // 기둥 삭제
                    if (columns[x][y + 1] == 0 && beams[x][y + 1] == 0) { //기둥 위에 아무것도 없으면 삭제 가능
                        columns[x][y] = 0;
                    } else if (beams[x][y + 1] == 1 && columns[x + 1][y] == 1) {// 위에 보 + 보를 지탱하는 다른 기둥 있으면 삭제 가능
                        columns[x][y] = 0;
                    } else if (beams[x][y + 1] == 1 && beams[x - 1][y + 1] == 1) {
                        columns[x][y] = 0;
                    }
                } else { // 보 삭제
                    if (columns[x][y - 1] == 1 || columns[x + 1][y - 1] == 1) { //양쪽 중 하나에 기둥이 있으면 삭제 가능
                        beams[x][y] = 0;
                    } else if (beams[x - 1][y] == 1 && beams[x + 1][y] == 1 &&
                            columns[x - 1][y - 1] == 1 ) { //양쪽 모두 보이면 삭제 가능
                        beams[x][y] = 0;
                    }
                }
            }
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (columns[i][j] == 1) {
                    list.add(new int[] {i, j, 0});
                }
                if (beams[i][j] == 1) {
                    list.add(new int[] {i, j, 1});
                }
            }
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[1]);
                } else {
                    if (o1[1] != o2[1]) {
                        return Integer.compare(o1[1], o2[1]);
                    } else {
                        return Integer.compare(o1[2], o2[2]);
                    }
                }
            }
        });

        int[][] answer = new int[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
