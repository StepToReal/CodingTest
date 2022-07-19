package com.code.codingtest.greedy;

public class Joystick {
    
    public static void main(String[] args) {
        String name = "JAN";

        System.out.println(new Joystick().solution(name));
    }

    public int solution(String name) {
        char[] charArr = name.toCharArray();
        boolean[] checkArr = new boolean[charArr.length];
        int[] moveCountArr = new int[2];

        for (int moveIndex = 0; moveIndex < moveCountArr.length; moveIndex++) {
        
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == 'A') checkArr[i] = true;
                else {
                    checkArr[i] = false;
                    int upCount = charArr[i] - 'A';
                    int downCount = Math.abs('Z' - charArr[i]) + 1;

                    if (upCount > downCount) moveCountArr[moveIndex] += downCount;
                    else moveCountArr[moveIndex] += upCount;            
                }
            }

            if (isAllCheck(checkArr)) { return 0; }

            int i = 0;
            int len = checkArr.length;

            if (moveIndex == 0) {
                if (!checkArr[i]) checkArr[i] = true;
                
                for (int moveCount = 1; moveCount < len; moveCount++) {
                    int index = goLeft(len, i, moveCount);

                    if (!checkArr[index]) {
                        i = index;
                        checkArr[i] = true;
                        moveCountArr[moveIndex] += moveCount;
                        break;
                    }
                }
            } else {
                if (!checkArr[i]) checkArr[i] = true;
                
                for (int moveCount = 1; moveCount < len; moveCount++) {
                    int index = goRight(len, i, moveCount);

                    if (!checkArr[index]) {
                        i = index;
                        checkArr[i] = true;
                        moveCountArr[moveIndex] += moveCount;
                        break;
                    }
                }
            }

            while (!isAllCheck(checkArr)) {
                int left = 0;
                int right = 0;

                for (int moveCount = 1; moveCount < len; moveCount++) {
                    int index = goLeft(len, i, moveCount);

                    if (!checkArr[index]) {
                        left = moveCount;
                        break;
                    }
                }

                for (int moveCount = 1; moveCount < len; moveCount++) {
                    int index = goRight(len, i, moveCount);

                    if (!checkArr[index]) {
                        right = moveCount;
                        break;
                    }
                }

                if (left > right) {
                    i = goRight(len, i, right);
                    checkArr[i] = true;
                    moveCountArr[moveIndex] += right;
                } else {
                    i = goLeft(len, i, left);
                    checkArr[i] = true;
                    moveCountArr[moveIndex] += left;
                }
            }
        }

        return Math.min(moveCountArr[0], moveCountArr[1]);
    }

    private boolean isAllCheck(boolean[] checkArr) {
        for (boolean b : checkArr) {
            if (!b) return false;
        }
        return true;
    }

    private int goLeft(int length, int cur, int move) {
        return cur - move >= 0 ? cur - move : length + cur - move;
    }

    private int goRight(int length, int cur, int move) {
        return cur + move < length ? cur + move : cur + move - length;
    }
}
