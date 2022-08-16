package com.code.codingtest.dynamicprogramming;

public class Thievery {
    int moneyLength = 0;

    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1}; //4
        int[] money2 = {8, 9, 7, 9, 10, 9}; //27
        int[] money3 = {99,60,1,51,100,51};

        System.out.println(new Thievery().solution(money3));
    }

    /*
    정확성에서 모두 실패함.. 양측 합이 가장 작은 숫자를 선택하는것에 오류가 있는것 같음.
    --> 문제가 있음 99,60,1,51,100,51 의 경우 99, 1, 100을 선택해서 200의 합이 가장 큰 수인데
        양측 합이 가장 적은 99,1 이 처음에 제외 되면서 최대값을 찾지 못하는 오류가 있음.
     */
    public int solution(int[] money) {
        int sum = 0;
        int answerCount = money.length / 2;
        moneyLength = money.length;

        for (int i = 0; i < answerCount; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < money.length; j++) {
                if (money[j] == 0) { continue; }
                if (money[preIndex(j)] == 0 && money[nextIndex(j)] == 0) { continue; }

                int bothSum = money[preIndex(j)] + money[nextIndex(j)];

                if (min > bothSum) {
                    min = bothSum;
                    minIndex = j;
                } else if (min == bothSum) {
                    if (money[minIndex] < money[j]) {
                        minIndex = j;
                    }
                }
            }

            if (minIndex != -1) {
                money[preIndex(minIndex)] = 0;
                money[nextIndex(minIndex)] = 0;
            }
        }

        for (int i = 0; i < moneyLength; i++) {
            sum += money[i];
        }

        return sum;
    }

    private int preIndex(int j) {
        if (j == 0) {
            return moneyLength - 1;
        } else {
            return j - 1;
        }
    }

    private int nextIndex(int j) {
        if (j == moneyLength - 1) {
            return 0;
        } else {
            return j + 1;
        }
    }
}
