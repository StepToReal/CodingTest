package com.code.codingtest.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumberImprove1 {
    
    public static void main(String[] args) {
        
        // int[] numbers = new int[1001];

        // for (int i = 0; i <= 1000; i++) {
        //     numbers[i] = i;
        // }

        int[] numbers = {1,10,100,1000};

        System.out.println(solution(numbers));
    }

    private static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }            
        });

        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            sb.append(item);
        }

        if (sb.indexOf("0") == 0) return "0";
        else return sb.toString();
    }
}
