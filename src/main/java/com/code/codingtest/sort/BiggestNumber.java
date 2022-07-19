package com.code.codingtest.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    
    public static void main(String[] args) {
        /*
            주어진 숫자 배열을 조합하여 가장 큰 수를 만들어 return
        */
        // int[] numbers = new int[1001];

        // for (int i = 0; i < 1001; i++) {
        //     numbers[i] = i;
        // }

        int[] numbers = {0,0,0,0,0};

        System.out.println(new BiggestNumber().solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        Arrays.sort(numbers);        
        String[] tempArray = new String[numbers.length];

        for (int i = 0 ; i < numbers.length; i++) {
            tempArray[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(tempArray, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                String o1 = "";
                String o2 = "";
                int reverse = 0;

                if (s1.length() <= s2.length()) {
                    o1 = s1;
                    o2 = s2;
                    reverse = 1;
                } else {
                    o1 = s2;
                    o2 = s1;
                    reverse = -1;
                }

                if (o1.length() == o2.length()) {
                    return Integer.parseInt(o1) <= Integer.parseInt(o2) ? 1 * reverse : -1 * reverse;
                } else if (o1.length() == 1) {
                    for (int i = 0; i < o2.length(); i++) {
                        int i1 = Integer.parseInt(o1);
                        int i2 = o2.charAt(i) - 48;

                        if (i1 < i2) return 1 * reverse;
                        else if (i1 == i2) continue;
                        else return -1 * reverse;
                    }
                    
                    return -1 * reverse;

                } else if (o1.length() == 2) {
                    int i1 = Integer.parseInt(o1);
                    int i2 = Integer.parseInt(o2.substring(0, 2));

                    if (i1 < i2) return 1 * reverse;
                    else if (i1 > i2) return -1 * reverse;
                    else {
                        i1 = o1.charAt(0) - 48;
                        i2 = o2.charAt(2) - 48;
                        
                        if (i1 < i2) return 1 * reverse;
                        else if (i1 > i2) return -1 * reverse;
                        else {
                            i2 = o2.charAt(1) - 48;

                            if (i1 <= i2) return -1 * reverse;
                            else return 1 * reverse;
                        }
                    }
                } else {
                    if (Integer.parseInt(o1) == 0) return 1 * reverse;
                    else return -1 * reverse;
                }
                    
            }
        });

        System.out.println(Arrays.toString(tempArray));

        for (String temp : tempArray) {
            answer += temp;
        }

        if (answer.length() - answer.replace("0", "").length() == answer.length()) {
            answer = "0";
        }

        return answer;
    }
}
