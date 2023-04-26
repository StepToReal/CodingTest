package com.code.functest;

import java.util.Scanner;

public class TimeConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();

        int hour = s / 3600;
        s %= 3600;

        int minute = s / 60;
        int second = s % 60;

        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}
