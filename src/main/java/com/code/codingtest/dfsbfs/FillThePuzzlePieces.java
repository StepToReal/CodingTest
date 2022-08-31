package com.code.codingtest.dfsbfs;

import java.util.*;

public class FillThePuzzlePieces {
    int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    //블럭 뽑아 오는건 문제 없음. 제대로 매칭이 안되는 문제가 있음.
    public static void main(String[] args) {
//        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
//        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        int[][] game_board = {{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}
                            , {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}
                            , {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}
                            , {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}
                            , {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}
                            , {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}
                            , {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}
                            , {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}
                            , {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}
                            , {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}
                            , {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}
                            , {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}};
        int[][] table = {{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}
                       , {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}
                       , {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0}
                       , {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}
                       , {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}
                       , {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
                       , {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}
                       , {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}
                       , {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}
                       , {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}
                       , {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}
                       , {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}};

        System.out.println(new FillThePuzzlePieces().solution(game_board, table));
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        //game board 에서 빈칸 찾기
        List<int[][]> boardEmptySpace = getSpace(game_board, 0);

        //table 에서 퍼즐 찾기
        List<int[][]> tableFillSpace = getSpace(table, 1);

        //board 빈칸들에 table item 회전하며 대입시키기
        for (int[][] tableSpace : tableFillSpace) {
            for (int[][] boardSpace : boardEmptySpace) {
                if (isMatchPuzzle(tableSpace, boardSpace)){
                    answer += getFillCount(tableSpace);
                    boardEmptySpace.remove(boardSpace);
                    break;
                }
            }
        }

        return answer;
    }

    private boolean isMatchPuzzle(int[][] tableSpace, int[][] boardSpace) {
        for (int i = 0; i < 4; i++) {
            tableSpace = rotate(tableSpace);

            if (Objects.deepEquals(boardSpace, tableSpace)) {
                return true;
            }
        }

        return false;
    }

    private int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotate = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotate[i][j] = matrix[n - 1 - j][i];
            }
        }

        return rotate;
    }

    private int getFillCount(int[][] tableSpace) {
        int cnt = 0;

        for (int i = 0; i < tableSpace.length; i++) {
            for (int j = 0; j < tableSpace[0].length; j++) {
                if (tableSpace[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private List<int[][]> getSpace(int[][] board, int num) {
        List<int[][]> resultList = new ArrayList<>();
        List<List<int[]>> puzzleCoordsList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == num) {
                    board[i][j] = -1;
                    List<int[]> puzzleCoords = new ArrayList<>();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] coord = queue.poll();
                        puzzleCoords.add(coord);

                        for (int k = 0; k < move.length; k++) {
                            if (coord[0] + move[k][0] >= board.length || coord[0] + move[k][0] < 0 ||
                                    coord[1] + move[k][1] >= board[0].length || coord[1] + move[k][1] < 0) {
                                continue;
                            }

                            int x = coord[0] + move[k][0];
                            int y = coord[1] + move[k][1];

                            if (board[x][y] == num) {
                                queue.add(new int[]{x, y});
                                board[x][y] = -1;
                            }
                        }
                    }
                    puzzleCoordsList.add(puzzleCoords);
                }
            }
        }

        //puzzleCoordList를 행렬로 변형
        for (List<int[]> puzzleCoords : puzzleCoordsList) {
            int xMin = puzzleCoords.stream().min(Comparator.comparingInt(o -> o[0])).get()[0];
            int yMin = puzzleCoords.stream().min(Comparator.comparingInt(o -> o[1])).get()[1];
            int xMax = puzzleCoords.stream().max(Comparator.comparingInt(o -> o[0])).get()[0];
            int yMax = puzzleCoords.stream().max(Comparator.comparingInt(o -> o[1])).get()[1];

            int[][] puzzleArr = new int[xMax - xMin + 1][yMax - yMin + 1];

            for (int[] puzzleCoord : puzzleCoords) {
                puzzleArr[puzzleCoord[0] - xMin][puzzleCoord[1] - yMin] = 1;
            }

            resultList.add(puzzleArr);
        }

        return resultList;
    }
}
