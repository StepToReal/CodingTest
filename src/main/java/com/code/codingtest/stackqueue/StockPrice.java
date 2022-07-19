package com.code.codingtest.stackqueue;

import java.util.Arrays;

public class StockPrice 
{
    public static void main( String[] args )
    {
        int[] prices = {1,2,3,2,3};
        int[] answer = new StockPrice().solution(prices);

        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int gap = 1;
            int num = prices[i];

            if (i == prices.length - 1) {
                answer[i] = 0;
            }

            for (int j = i + 1; j < prices.length; j++) {
                if (num > prices[j]) {
                    answer[i] = gap;
                    break;
                } else if (j == prices.length - 1) {
                    answer[i] = j - i;
                } else {
                    gap++;
                }
            }
        }

        return answer;
    }
}
