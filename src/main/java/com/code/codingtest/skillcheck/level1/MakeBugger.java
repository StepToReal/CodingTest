package com.code.codingtest.skillcheck.level1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MakeBugger {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(new MakeBugger().solution(ingredient));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new LinkedList<>();

        for (int i : ingredient) {
            list.add(i);

            if (i == 1 && list.size() >= 4) {
                int index = list.size() - 1;

                if (list.get(index - 1) == 3 &&
                        list.get(index - 2) == 2 &&
                        list.get(index - 3) == 1) {
                    answer++;
                    list.remove(index);
                    list.remove(index - 1);
                    list.remove(index - 2);
                    list.remove(index - 3);
                }
            }
        }

        return answer;
    }
}
