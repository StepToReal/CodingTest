package com.code.codingtest.skillcheck.level1;

import java.util.Stack;

public class ClawCraneGame {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(new ClawCraneGame().solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            move -= 1;

            for (int i = 0; i < board.length; i++) {
                if (board[i][move] != 0) {
                    int temp = board[i][move];
                    board[i][move] = 0;

                    if (stack.isEmpty() || stack.peek() != temp) {
                        stack.add(temp);
                    } else {
                        stack.pop();
                        answer += 2;
                    }

                    break;
                }
            }
        }

        return answer;
    }
}
