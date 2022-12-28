package com.code.codingtest.skillcheck.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultilevelToothbrushSales {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(new MultilevelToothbrushSales().solution(enroll, referral, seller, amount)));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, SalesPerson> map = new HashMap<>();

        for (String e : enroll) {
            map.put(e, new SalesPerson(e));
        }

        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                continue;
            }

            map.get(enroll[i]).referral = map.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            map.get(seller[i]).addIncome(amount[i] * 100);
        }

        int index = 0;
        for (String e : enroll) {
            answer[index++] = map.get(e).income;
        }

        return answer;
    }
}

class SalesPerson {
    SalesPerson referral;
    String name;
    int income;

    public SalesPerson(String name) {
        this.name = name;
    }

    public void addIncome(int income) {
        int offer = income / 10;
        int mine = income - offer;

        this.income += mine;

        if (referral != null) {
            referral.addIncome(offer);
        }
    }
}
