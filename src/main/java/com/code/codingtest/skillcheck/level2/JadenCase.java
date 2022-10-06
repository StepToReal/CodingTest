package com.code.codingtest.skillcheck.level2;

import java.util.Arrays;
import java.util.StringTokenizer;

public class JadenCase {
    public static void main(String[] args) {
        String s = "3people     unFollowed me";

        System.out.println(new JadenCase().solution(s));
    }

    public String solution(String s) {

        String[] sp = s.split("");
        System.out.println(Arrays.toString(sp));

        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuffer sb = new StringBuffer();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.equals(" ")) {
                sb.append(token);
            } else if (token.length() > 1) {
                token = token.substring(0, 1).toUpperCase() + token.substring(1).toLowerCase();
                sb.append(token);
            } else {
                sb.append(token.toUpperCase());
            }
        }

        return sb.toString();
    }
}
