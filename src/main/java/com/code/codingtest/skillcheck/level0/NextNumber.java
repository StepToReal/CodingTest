package com.code.codingtest.skillcheck.level0;

import com.code.codingtest.skillcheck.level2.NextBigNumber;

public class NextNumber {
    public static void main(String[] args) {
//        int[] common = {1, 2, 3, 4};
        int[] common = {2,4,8};

        System.out.println(new NextNumber().solution(common));
    }

    public int solution(int[] common) {
        int value = 0;
        boolean isAdd = false;

        if ((common[1] - common[0]) == (common[2] - common[1])) {
            value = common[1] - common[0];
            isAdd = true;
        } else if ((common[1] % common[0] == 0) && (common[2] % common[1] == 0)
                && (common[1] / common[0]) == (common[2] / common[1])) {
            value = common[1] / common[0];
            isAdd = false;
        }

        return isAdd ? common[common.length - 1] + value : common[common.length - 1] * value;
    }
}
