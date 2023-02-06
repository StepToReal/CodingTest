package com.code.codingtest.skillcheck.level0;

import java.math.BigInteger;

public class BallsDivideNum {
    public static void main(String[] args) {

    }

    public int solution(int balls, int share) {
        int answer = 0;

        answer = (getFactorial(balls).divide(getFactorial(balls - share).multiply(getFactorial(share)))).intValue();

        return answer;
    }

    private BigInteger getFactorial(int n) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = n; i > 1; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
