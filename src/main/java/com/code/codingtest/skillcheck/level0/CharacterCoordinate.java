package com.code.codingtest.skillcheck.level0;

import java.util.function.Function;

public class CharacterCoordinate {
    public static void main(String[] args) {

    }

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};

        for (String input : keyinput) {
            switch (input) {
                case "up":
                    answer[1] = Math.min(answer[1] + 1, board[1] / 2);
                    break;
                case "down":
                    answer[1] = Math.max(answer[1] - 1, -board[1] / 2);
                    break;
                case "right":
                    answer[0] = Math.min(answer[0] + 1, board[0] / 2);
                    break;
                case "left":
                    answer[0] = Math.max(answer[0] - 1, -board[0] / 2);
                    break;
            }
        }

        return answer;
    }
}
