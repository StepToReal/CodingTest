package com.code.codingtest.skillcheck.level3;

import java.util.*;

public class LongestPalindrome {
    public static void main(String[] args) {
//        System.out.println(new LongestPalindrome().solution("abcdcba") + ", " + 7);
//        System.out.println(new LongestPalindrome().solution("abacde") + ", " + 3);
        System.out.println(new LongestPalindrome().solution("abcabcdcbae") + ", " + 7);
//        System.out.println(new LongestPalindrome().solution("aaaa") + ", " + 4);
//        System.out.println(new LongestPalindrome().solution("abcde") + ", " + 1);
//        System.out.println(new LongestPalindrome().solution("a") + ", " + 1);
        System.out.println(new LongestPalindrome().solution("abcbaqwertrewqq") + ", " + 9);
//        System.out.println(new LongestPalindrome().solution("abcbaqwqabcba") + ", " + 13);
//        System.out.println(new LongestPalindrome().solution("abba") + ", " + 4);
//        System.out.println(new LongestPalindrome().solution("abaabaaaaaaa") + ", " + 7);
    }

    public int solution(String s) {
        //"aaaabaaaa", "aaaaa", "aabvcxz"

        int len = s.length();
        StringBuilder frontMoveString;
        StringBuilder backMoveString;
        Set<String> palindromeStrings = new HashSet<>();
        String reverse = new StringBuilder(s).reverse().toString();

        if (s.equals(reverse)) {
            return len;
        }

        for (int i = 0; i < len; i++) {
            frontMoveString = new StringBuilder();
            backMoveString = new StringBuilder();

            for (int j = 0; j < len; j++) {
                if (i + j > len - 1) {
                    if (frontMoveString.length() > 0) {
                        palindromeStrings.add(frontMoveString.toString());
                    }
                    if (backMoveString.length()> 0) {
                        palindromeStrings.add(backMoveString.toString());
                    }
                    break;
                }

                if (s.charAt(i + j) == reverse.charAt(j)) {
                    backMoveString.append(s.charAt(i + j));
                } else {
                    if (backMoveString.length() > 0){
                        palindromeStrings.add(backMoveString.toString());
                    }
                    backMoveString = new StringBuilder();
                }

                if (s.charAt(j) == reverse.charAt(i + j)) {
                    frontMoveString.append(s.charAt(j));
                } else {
                    if (frontMoveString.length() > 0) {
                        palindromeStrings.add(frontMoveString.toString());
                    }
                    frontMoveString = new StringBuilder();
                }
            }
        }

        Iterator<String> it = palindromeStrings.iterator();

        while (it.hasNext()) {
            String palindrome = it.next();

            if (palindrome.length() == 1) {
                continue;
            }

            if (!palindrome.equals(new StringBuilder(palindrome).reverse().toString())) {
                it.remove();
            }
        }

        return palindromeStrings.stream().map(String::length).max(Integer::compare).orElse(0);
    }
}
