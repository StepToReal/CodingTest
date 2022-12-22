package com.code.codingtest.skillcheck.level0;

public class ChickenCoupon {
    public static void main(String[] args) {
        System.out.println(new ChickenCoupon().solution(1999));
    }

    public int solution(int chicken) {
        int serviceChicken = 0;

        while (chicken > 9) {
            serviceChicken += chicken / 10;
            chicken = (chicken / 10) + (chicken % 10);
        }

        return serviceChicken;
    }
}
