package com.code.codingtest.skillcheck.level3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestPalindromeImprove {
    public static void main(String[] args) {
//        System.out.println(new LongestPalindromeImprove().solution("abcdcba") + ", " + 7);
//        System.out.println(new LongestPalindromeImprove().solution("abacde") + ", " + 3);
//        System.out.println(new LongestPalindromeImprove().solution("abcabcdcbae") + ", " + 7);
//        System.out.println(new LongestPalindromeImprove().solution("aaaa") + ", " + 4);
//        System.out.println(new LongestPalindromeImprove().solution("abcde") + ", " + 1);
//        System.out.println(new LongestPalindromeImprove().solution("a") + ", " + 1);
//        System.out.println(new LongestPalindromeImprove().solution("abcbaqwertrewqq") + ", " + 9);
//        System.out.println(new LongestPalindromeImprove().solution("abcbaqwqabcba") + ", " + 13);
//        System.out.println(new LongestPalindromeImprove().solution("abba") + ", " + 4);
        System.out.println(new LongestPalindromeImprove().solution("abaabaaaaaaa") + ", " + 7);
    }

    public int solution(String s) {
        int searchLen = s.length();
        boolean isPalindrome;

        for (; searchLen > 0; searchLen--) {
            if (searchLen == 1) break;

            for (int start = 0; start + searchLen - 1 < s.length(); start++) {
                int end = start + searchLen - 1;
                int mid = searchLen % 2 == 0 ? searchLen / 2 : searchLen / 2 + 1;

                isPalindrome = true;

                for (int i = 0; i < mid; i++) {
                    if (s.charAt(start + i) != s.charAt(end - i)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) return searchLen;
            }
        }

        return 1;
    }
}
