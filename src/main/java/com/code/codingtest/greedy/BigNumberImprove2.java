package com.code.codingtest.greedy;

public class BigNumberImprove2 {
    public static void main(String[] args) {
        String number = "67429495152"; 
        int k = 3;

        System.out.println(new BigNumber().solution(number, k));
    }
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i + 1 < sb.length() && k > 0; i++) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i = -1;
                k--;
            }
        }

        if (k != 0) {
            sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();
    }
}
