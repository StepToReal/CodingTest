package com.code.codingtest.skillcheck.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockAndKey {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] lock = {{1, 1, 1}, {0, 1, 1}, {1, 0, 0}};

        System.out.println(new LockAndKey().solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int[][] lockUseSpace = getUseSpace(lock);

        if (lockUseSpace == null) {
            return true;
        }

        List<int[][]> keySpaces = new ArrayList<>();

        for (int i = 0; i <= key.length - lockUseSpace.length; i++) {
            for (int j = 0; j <= key.length - lockUseSpace[0].length; j++) {
                int[][] keySpace = getKeySpace(key, i, j, lockUseSpace); // 정사각이 아니면 가로로 세로로 둘다 뽑아야 함.
                keySpaces.add(keySpace);
            }
        }

        for (int i = 0; i <= key.length - lockUseSpace[0].length; i++) {
            for (int j = 0; j <= key.length - lockUseSpace.length; j++) {
                int[][] keySpace = getKeySpace(key, i, j, rotate(lockUseSpace)); // 정사각이 아니면 가로로 세로로 둘다 뽑아야 함.
                keySpaces.add(keySpace);
            }
        }

        for (int[][] keySpace : keySpaces) {
            for (int i = 0; i < 4; i++) {
                keySpace = rotate(keySpace);
                if (isMatch(keySpace, lockUseSpace)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isMatch(int[][] keyRotate, int[][] lockUseSpace) {
        if (keyRotate.length != lockUseSpace.length || keyRotate[0].length != lockUseSpace[0].length) {
            return false;
        }

        int iLength = keyRotate.length;
        int jLength = keyRotate[0].length;

        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (keyRotate[i][j] + lockUseSpace[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
    private int[][] rotate(int[][] key) {
        int iLength = key.length;
        int jLength = key[0].length;
        int[][] result = new int[jLength][iLength];

        for (int i = 0; i < jLength; i++) {
            for (int j = 0; j < iLength; j++) {
                result[i][j] = key[iLength - j - 1][i];
            }
        }

        return result;
    }

    private int[][] getKeySpace(int[][] key, int startI, int startJ, int[][] length) {
        int iLength = length.length;
        int jLength = length[0].length;
        int[][] result = new int[iLength][jLength];

        for (int i = startI; i < startI + iLength; i++) {
            result[i - startI] = Arrays.copyOfRange(key[i], startJ, startJ + jLength);
        }

        return result;
    }

    private int[][] getUseSpace(int[][] lock) {
        List<Integer> coordX = new ArrayList<>();
        List<Integer> coordY = new ArrayList<>();

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    coordX.add(i);
                    coordY.add(j);
                }
            }
        }

        if (coordX.isEmpty() || coordY.isEmpty()) {
            return null;
        }

        int rowMin = coordX.stream().min(Integer::compare).orElse(0);
        int rowMax = coordX.stream().max(Integer::compare).orElse(0);
        int colMin = coordY.stream().min(Integer::compare).orElse(0);
        int colMax = coordY.stream().max(Integer::compare).orElse(0);
        int[][] result = new int[rowMax - rowMin + 1][colMax - colMin + 1];

        for (int i = rowMin; i <= rowMax; i++) {
            result[i - rowMin] = Arrays.copyOfRange(lock[i], colMin, colMax + 1);
        }

        return result;
    }
}
