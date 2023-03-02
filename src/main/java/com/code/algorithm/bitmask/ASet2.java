package com.code.algorithm.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ASet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[21];

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            int value = !command.equals("all") && !command.equals("empty") ? Integer.parseInt(commands[1]) : 0;

            switch (command) {
                case "add":
                    arr[value] = 1; break;
                case "remove":
                    arr[value] = 0; break;
                case "check":
                    sb.append(arr[value]).append("\n"); break;
                case "toggle":
                    arr[value] = arr[value] == 0 ? 1 : 0;
                    break;
                case "all":
                    Arrays.fill(arr, 1);
                    break;
                case "empty":
                    Arrays.fill(arr, 0);
                    break;
            }
        }

        System.out.println(sb);
    }
}
