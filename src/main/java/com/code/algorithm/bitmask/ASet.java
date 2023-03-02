package com.code.algorithm.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ASet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = 0;

        int count = Integer.parseInt(br.readLine());

        while (count-- > 0) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            int value = !command.equals("all") && !command.equals("empty") ? Integer.parseInt(commands[1]) : 0;

            switch (command) {
                case "add":
                    num |= (1 << (value - 1)); break;
                case "remove":
                    num &= ~(1 << (value - 1)); break;
                case "check":
                    sb.append((num & 1 << (value - 1)) != 0 ? "1\n" : "0\n"); break;
                case "toggle":
                    num ^= (1 << (value - 1));
                    break;
                case "all":
                    num |= (~0);
                    break;
                case "empty":
                    num &= (0);
                    break;
            }
        }

        System.out.println(sb);
    }
}
