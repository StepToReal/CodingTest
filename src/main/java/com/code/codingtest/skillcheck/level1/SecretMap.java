package com.code.codingtest.skillcheck.level1;

public class SecretMap {
    public static void main(String[] args) {
        System.out.println(String.format("%05s", Integer.toBinaryString(9)));


    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String s = "";
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);

            if (s1.length() < n) {
                int gap = n - s1.length();

                for (int j = 0; j < gap; j++) {
                    s1 = "0" + s1;
                }
            }
            if (s2.length() < n) {
                int gap = n - s2.length();

                for (int j = 0; j < gap; j++) {
                    s2 = "0" + s2;
                }
            }

            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) == '1' || s2.charAt(j) == '1') {
                    s += "#";
                } else {
                    s += " ";
                }
            }

            answer[i] = s;
        }

        return answer;
    }
}
