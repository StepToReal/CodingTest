package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class CompressMessage {
    public static void main(String[] args) {
        int[] result = new CompressMessage().solution("ABABABABABABABAB");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String msg) {
        Map<String, Integer> addDic = new HashMap<>();
        List<Integer> indexResult = new ArrayList<>();
        int index = 27;

        if (msg.length() < 3) {
            for (Character c : msg.toCharArray()) {
                indexResult.add(c - 64);
            }
        } else {
            for (int i = 0; i < msg.length(); i++) {
                if (addDic.isEmpty()) {
                    indexResult.add(msg.charAt(i) - 64);
                    addDic.put(msg.substring(i, i + 2), index++);
                } else if (i == msg.length() - 1) {
                    indexResult.add(msg.charAt(i) - 64);
                } else {
                    String prevString = "";

                    for (int j = i + 1; j < msg.length(); j++) {
                        String temp = msg.substring(i, j + 1);
                        if (!addDic.containsKey(temp)) {
                            addDic.put(temp, index++);

                            if (temp.length() == 2) {
                                indexResult.add(msg.charAt(i) - 64);
                            } else {
                                indexResult.add(addDic.get(prevString));
                                i += prevString.length() - 1;
                            }
                            prevString = "";
                            break;
                        } else {
                            prevString = temp;
                        }
                    }

                    if (!prevString.isEmpty()) {
                        indexResult.add(addDic.get(prevString));
                        i += prevString.length() - 1;
                    }
                }
            }
        }

        return indexResult.stream().mapToInt(Integer::intValue).toArray();
    }
}
