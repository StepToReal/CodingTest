package com.code.codingtest.dfsbfs;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int[] numbers2 = {4,1,2,1,1,1};

        int target = 3; //5
        int target2 = 2; //2

        System.out.println(new TargetNumber().solution(numbers2, target2));
    }

    //실패
    public int solution(int[] numbers, int target) {
        int total = 0;
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }

        int subNumber = (total - target) / 2;

        if (subNumber == 0) {
            return 1;
        } else if ((total - target) % 2 != 0) {
            return 0;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (subNumber == numbers[i]) {
                result++;
            } else if (subNumber > numbers[i] && i < numbers.length - 1) {
                int subTotal = numbers[i];

                for (int j = i + 1; j < numbers.length; j++) {
                    int temp = subTotal + numbers[j];

                    if (temp == subNumber) {
                        result++;
                    } else if (temp < subNumber) {
                        for (int k = j + 1; k < numbers.length; k++) {
                            temp += numbers[k];

                            if (temp == subNumber) {
                                result++;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
