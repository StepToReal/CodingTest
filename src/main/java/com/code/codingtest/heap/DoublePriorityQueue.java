package com.code.codingtest.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class DoublePriorityQueue {
    
    public static void main(String[] args) {
        /*
            I 숫자 - 큐에 숫자 삽입
            D 1 - 큐에서 최대값 삭제
            D -1 - 큐에서 최소값 삭제


        */
        // String[] operation = {"I 7","I 5","I -5","D -1"};
        // String[] operation = {"I 16", "D 1"};
        // String[] operation = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        // String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        // String[] operation = {"D 1", "D -1", "D 1"};
        String[] operation = {"D 1", "D -1", "D 1"};

        System.out.println(Arrays.toString(new DoublePriorityQueue().solution(operation)));
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        LinkedList<Integer> ll = new LinkedList<Integer>();

        String[] operators = new String[operations.length];
        int[] numbers = new int[operations.length];

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            operators[i] = temp[0];
            numbers[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("I")) {
                ll.add(numbers[i]);
            } else if (operators[i].equals("D")) {
                if (numbers[i] == 1 && !ll.isEmpty()) {
                    Collections.sort(ll);
                    ll.removeLast();
                } else if (numbers[i] == -1 && !ll.isEmpty()) {
                    Collections.sort(ll);
                    ll.removeFirst();
                }
            }
        }

        if (ll.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            Collections.sort(ll);
            answer[0] = ll.getLast();
            answer[1] = ll.getFirst();
        }

        return answer;
    }
}