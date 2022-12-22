package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class CacheImprove {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        System.out.println(new CacheImprove().solution(cacheSize, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                answer++;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;

                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }

                cache.add(city);
            }
        }
        return answer;
    }
}