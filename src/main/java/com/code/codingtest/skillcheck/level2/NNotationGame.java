package com.code.codingtest.skillcheck.level2;

public class NNotationGame {
    public static void main(String[] args) {
        System.out.println(new NNotationGame().solution(2,4,2,1));

        System.out.println(Integer.toString(13, 13));
    }

    public String solution(int n, int t, int m, int p) {

        int num = 0;
        int order = 1;
        int rotation = 0;
        StringBuilder answer = new StringBuilder();

        while (answer.length() < t) {
            String nNum = Integer.toString(num, n).toUpperCase();

            for (int i = 0; i < nNum.length(); i++) {
                if ((p + (m * rotation)) == order) {
                    answer.append(nNum.charAt(i));
                    rotation++;
                }

                if (answer.length() >= t) break;

                order++;
            }

            num++;
        }

        return answer.toString();
    }

//    public String getNotationNumber(int num, int n) {
//        StringBuilder result = new StringBuilder();
//
//        if (num == 0 || num == 1) return String.valueOf(num);
//        else {
//            while (num != 0) {
//                int remainder = num % n;
//
//                if (remainder >= 10) {
//                    result.append((char) (remainder + 55));
//                } else {
//                    result.append(remainder);
//                }
//
//                num = num / n;
//            }
//        }
//
//        return result.reverse().toString();
//    }
}
