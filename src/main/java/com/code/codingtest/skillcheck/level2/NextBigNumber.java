package com.code.codingtest.skillcheck.level2;

import sun.security.x509.NetscapeCertTypeExtension;

public class NextBigNumber {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(10));

//        System.out.println(new NextBigNumber().solution(15));
    }

    public int solution(int n) {
        int answer = 0;

        String nBinary = Integer.toBinaryString(n);
        int oneCount = nBinary.replace("0", "").length();

        for (int i = n + 1; i <= 1000000; i++) {
            String nextBigNumBinary = Integer.toBinaryString(i);
            int bigNumOneCount = nextBigNumBinary.replace("0", "").length();

            if (oneCount == bigNumOneCount) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
