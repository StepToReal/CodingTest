package com.code.codingtest.skillcheck.level3;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import com.sun.xml.internal.ws.resources.AddressingMessages;

import java.awt.dnd.DropTargetListener;
import java.util.*;

public class JewelryShopping {
    public static void main(String[] args) {
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        System.out.println(Arrays.toString(new JewelryShopping().solution(gems)));
    }

    //시간초과 발생
    public int[] solution(String[] gems) {
        Set<String> gemFullSet = new HashSet<>(Arrays.asList(gems));
        Set<String> gemSet;
        int[] answer = new int[2];

        int size = gemFullSet.size();

        Loop:
        for (; size <= gems.length; size++) {
            for (int i = 0; i + size <= gems.length; i++) {
                gemSet = new HashSet<>(Arrays.asList(gems).subList(i, i + size));

                if (gemSet.containsAll(gemFullSet)) {
                    answer[0] = i + 1;
                    answer[1] = i + size;
                    break Loop;
                }
            }
        }

        return answer;
    }
}
