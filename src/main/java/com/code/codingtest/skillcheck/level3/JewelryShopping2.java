package com.code.codingtest.skillcheck.level3;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

import java.util.*;

public class JewelryShopping2 {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};

        System.out.println(Arrays.toString(new JewelryShopping2().solution(gems)));
    }

    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> gemsMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        int start = 0;
        int temp = 0;
        int len = Integer.MAX_VALUE;

        for (String gem : gems) {
            queue.add(gem);
            gemsMap.put(gem, gemsMap.getOrDefault(gem, 0) + 1);

            while (true) {
                String firstInputGem = queue.peek();

                if (gemsMap.get(firstInputGem) > 1) {
                    gemsMap.replace(firstInputGem, gemsMap.get(firstInputGem) - 1);
                    queue.poll();
                    temp++;
                } else {
                    break;
                }
            }

            if (gemsMap.size() == gemKinds.size() && len > queue.size()) {
                len = queue.size();
                start = temp;
            }
        }

        return new int[] {start + 1, start + len};
    }
}
