package com.code.codingtest.greedy;

public class BigNumber {
    public static void main(String[] args) {
        String number = "1111"; 
        int k = 3;

        System.out.println(new BigNumber().solution(number, k));
    }
    
    public String solution(String number, int k) {
        char[] charArr = number.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int searchLen = i + k < charArr.length ? k : charArr.length - (i + 1);

            for (int j = 1; j <= searchLen; j++) {
                if (charArr[i] < charArr[i + j]) {
                    charArr[i] = 'A';
                    k--;
                    break;
                }
            }
        }

        if (k > 0) {
            Loop:
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j < charArr.length; j++) {
                    if (i == charArr[j] - 48) {
                        charArr[j] = 'A';
                        
                        if (--k == 0) {
                            break Loop;
                        }
                    }  
                }
            }
        }       

        return new String(charArr).replace("A", "");
    }
}
