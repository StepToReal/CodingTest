package com.code.codingtest.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class TrainingWear {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,2,4};
        int[] reserve = {2,3,4,5};

        System.out.println(new TrainingWear().solution(n, lost, reserve));
    }

    public int solution (int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();

        for (int l : lost) lostList.add(l);
        for (int r : reserve) reserveList.add(r);
        
        for (int i = reserveList.size() - 1; i >= 0; i--) {
            
            for (int j = lostList.size() - 1; j >= 0; j--) {
                if (reserveList.get(i) == lostList.get(j)) {
                    reserveList.remove(i);
                    lostList.remove(j);
                    break;
                }
            }
        }

        Iterator<Integer> lostIt = lostList.iterator();
        Iterator<Integer> reserveIt = reserveList.iterator();

        while(reserveIt.hasNext()) {
            int reserveNum = reserveIt.next();
            lostIt = lostList.iterator();

            while(lostIt.hasNext()) {
                int lostNum = lostIt.next();

                if (reserveNum + 1 == lostNum || reserveNum - 1 == lostNum) {
                    lostIt.remove();
                    break;
                }
            }
        }
        
        return n - lostList.size();
    }
}
