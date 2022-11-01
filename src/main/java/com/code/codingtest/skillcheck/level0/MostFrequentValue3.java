package com.code.codingtest.skillcheck.level0;

import sun.security.x509.IssuingDistributionPointExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentValue3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};

        System.out.println(new MostFrequentValue3().solution(array));
    }

    public int solution(int[] array) {
        int maxNum = 0;
        int maxIndex = -1;
        boolean isDuplicate = false;
        int[] frequentArr = new int[1000];

        for (int i = 0; i < array.length; i++) {
            frequentArr[array[i]]++;
        }

        for (int i = 0; i < frequentArr.length; i++) {
            if (frequentArr[i] == 0) continue;

            if (maxNum < frequentArr[i]) {
                maxNum = frequentArr[i];
                maxIndex = i;
                isDuplicate = false;
            } else if (maxNum == frequentArr[i]) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? -1 : maxIndex;
    }
}
