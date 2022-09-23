package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class Problem01 {
    /*
    progresses 는 진행된 정도, speeds는 하루에 처리할 수 있는 진행량.
    progresses 순서는 일의 진행 순서로 변경되지 않으며 뒤에 일이 먼저 끝나도 앞에 일이 끝나지 않았으면 배포될 수 없다.
    각 배포일에 배포되는 일의 개수를 구하라.

    ex>
    int[] progresses = {95, 90, 99, 99, 80, 99};
    int[] speeds = {1, 1, 1, 1, 1, 1};
    인 경우 일이 완료되기 위해 추가로 필요한 날짜는 {5, 10, 1, 1, 20, 1} 이 되며
    각 배포 별 배포되는 일의 개수는 {1,3,2} 이다.
     */
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(new Problem01().solution(progresses, speeds)));
    }

    private int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] periods = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                periods[i] = (100 - progresses[i]) / speeds[i];
            } else {
                periods[i] = ((100 - progresses[i]) / speeds[i]) + 1;
            }
        }

        answer = new int[periods.length];
        int answerIndex = 0;

        outerLoop: {
            for (int i = 0; i < periods.length - 1; i++) {
                int base = periods[i];

                for (int j = i + 1; j < periods.length; j++) {
                    int target = periods[j];

                    if (base < target) {
                        answer[answerIndex++] = j - i;

                        if (j == periods.length - 1) {
                            answer[answerIndex++] = 1;
                            break outerLoop;
                        } else {
                            i = j - 1;
                            break;
                        }
                    } else if (j == periods.length - 1) {
                        answer[answerIndex++] = j - i + 1;
                        break outerLoop;
                    }
                }
            }
        }

        answer = Arrays.copyOfRange(answer, 0, answerIndex);

        return answer;
    }
}
