package com.code.codingtest.sort;

import java.util.Arrays;

public class FindKstNumber {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        int[] result = new FindKstNumber().solution(array, commands);
        System.out.println(Arrays.toString(result));        
    }   
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int index = commands[i][2] - 1;

            int[] temp = Arrays.copyOfRange(array, from, to);
            Arrays.sort(temp);
            answer[i] = temp[index];
        }

        return answer;
    }
}
