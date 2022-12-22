package com.code.codingtest.skillcheck.level2;

import java.util.*;

public class Cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        System.out.println(new Cache().solution(cacheSize, cities));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<CacheItem> cache = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();
            CacheItem cityItem = new CacheItem(city);

            if (cache.size() > 0) {
                for (CacheItem item : cache) {
                    item.addMatchCount();
                }
            }

            if (cache.contains(cityItem)) {
                answer++;
                cache.get(cache.indexOf(cityItem)).setLastMatchCount();
            } else {
                answer += 5;
                cache.add(new CacheItem(city, 0));
            }

            if (cache.size() > cacheSize) {
                String oldestCity = cache.stream().max(Comparator.comparing(CacheItem::getMatchCount)).get().getCity();
                cache.remove(new CacheItem(oldestCity));
            }
        }

        return answer;
    }
}

class CacheItem {
    private String city;
    private Integer matchCount;

    CacheItem(String city) {
        this.city = city;
    }

    CacheItem(String city, int matchCount) {
        this.city = city;
        this.matchCount = matchCount;
    }

    public String getCity() {
        return city;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public void addMatchCount() {
        matchCount++;
    }

    public void setLastMatchCount() {
        matchCount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CacheItem) {
            CacheItem target = (CacheItem) o;
            return city.equals(target.city);
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}
