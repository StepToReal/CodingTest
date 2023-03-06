package com.code.codingtest.skillcheck.level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(new DiscountEvent().solution(want, number, discount));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantByCount = new HashMap<>();
        Map<String, Integer> discountByCount = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantByCount.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            discountByCount.put(discount[i], discountByCount.getOrDefault(discount[i], 0) + 1);

            if (isMatch(wantByCount, discountByCount)) {
                answer++;
            }
        }

        for (int i = 1; i + 9 < discount.length; i++) {
            String prevItem = discount[i - 1];
            String nextItem = discount[i + 9];
            discountByCount.put(prevItem, discountByCount.get(prevItem) - 1);
            discountByCount.put(nextItem, discountByCount.getOrDefault(nextItem, 0) + 1);

            if (isMatch(wantByCount, discountByCount)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isMatch(Map<String, Integer> wantByCount, Map<String, Integer> discountByCount) {
        for (Map.Entry<String, Integer> wantEntry : wantByCount.entrySet()) {
            if (!discountByCount.containsKey(wantEntry.getKey()) ||
                    discountByCount.get(wantEntry.getKey()) != wantEntry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
