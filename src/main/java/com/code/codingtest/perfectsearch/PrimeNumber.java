package com.code.codingtest.perfectsearch;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrimeNumber {
    
    Set<Integer> resultSet = new HashSet<>();

    public static void main(String[] args) {

        String numbers = "1231";
        System.out.println(new PrimeNumber().solution(numbers));        
    }

    public int solution(String numbers) {
        int count = 0;
        recursive("", numbers);

        Iterator<Integer> it = resultSet.iterator();

        while (it.hasNext()) {
            boolean isPrime = true;
            int num = it.next().intValue();

            if (num == 0 || num == 1) continue;

            for (int i = 2; i < (num / 2) + 1; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;  
                System.out.println(num);
            }          
        }

        return count;
    }

    private void recursive(String comb, String others) {

        if (!comb.equals("")) 
            resultSet.add(Integer.parseInt(comb));

        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
}

