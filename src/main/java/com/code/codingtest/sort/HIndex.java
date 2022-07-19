package com.code.codingtest.sort;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {1,4};

        System.out.println(new HIndex().solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;

        Integer[] citationIntegers = new Integer[citations.length];

        for (int i = 0; i < citations.length; i++) {
            citationIntegers[i] = citations[i];
        }

        Arrays.sort(citationIntegers, Collections.reverseOrder());

        for (int i = citationIntegers[0]; i >= 0; i--) {
            int cnt = 0;

            for (int j = 0; j < citationIntegers.length; j++) {
                if (i <= citationIntegers[j]) 
                    cnt++;
            }

            if (cnt >= i) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}