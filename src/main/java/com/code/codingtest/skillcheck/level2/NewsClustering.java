package com.code.codingtest.skillcheck.level2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NewsClustering {
    public static void main(String[] args) {
        System.out.println(new NewsClustering().solution("aa1+aa2", "AAAA12"));
    }

    public int solution(String str1, String str2) {
        List<String> str1List = getStrList(str1);
        List<String> str2List = getStrList(str2);

        List<String> intersection = getInterSection(str1List, str2List);
        List<String> sumOfSet = getSumOfSet(str1List, str2List, intersection);

        if (intersection.isEmpty() && sumOfSet.isEmpty()) {
            return 65536;
        }

        return (int)((intersection.size() / (double)sumOfSet.size()) * 65536);
    }

    private List<String> getSumOfSet(List<String> list1, List<String> list2, List<String> intersection) {
        List<String> result = new ArrayList<>();

        result.addAll(getComplementarySet(list1, intersection));
        result.addAll(getComplementarySet(list2, intersection));
        result.addAll(intersection);

        return result;
    }

    private Collection<String> getComplementarySet(List<String> list, List<String> intersection) {
        for (String inter : intersection) {
            list.remove(inter);
        }

        return list;
    }

    private List<String> getInterSection(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();

        Iterator<String> iter1 = new ArrayList<>(list1).iterator();
        List<String> list2Temp = new ArrayList<>(list2);

        while (iter1.hasNext()) {
            String s1 = iter1.next();
            Iterator<String> iter2 = list2Temp.iterator();
            while (iter2.hasNext()) {
                String s2 = iter2.next();

                if (s1.equals(s2)) {
                    result.add(s1);
                    iter1.remove();
                    iter2.remove();
                    break;
                }
            }
        }

        return result;
    }

    private List<String> getStrList(String str) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);

            if (!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }

            result.add(new String(new char[]{c1, c2}).toLowerCase());
        }

        return result;
    }
}
