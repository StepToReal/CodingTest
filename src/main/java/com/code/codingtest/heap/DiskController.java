package com.code.codingtest.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DiskController {
    
    public static void main(String[] args) {
        
        /*
            jobs의 길이는 1 이상 500 이하입니다.
            jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
            각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
            각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
            하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다
        */
        
        // int[][] jobs = {{0,3}, {1,9}, {2,6}};
        // int[][] jobs = {{0,3},{1,4},{1,2},{4,3},{4,1},{5,3},{6,10}};
        int[][] jobs = {{1,2}, {1,3}, {2,2}, {12,1}, {12,2}, {14,1}, {14,7}};

        System.out.println(new DiskController().solution(jobs));
    }

    public int solution(int[][] jobs) {
        PriorityQueue<DiskOrder> processQueue = new PriorityQueue<DiskOrder>();
        ArrayList<DiskOrder> list = new ArrayList<DiskOrder>(jobs.length);
        LinkedList<DiskOrder> linkedList = new LinkedList<DiskOrder>();

        for (int[] job : jobs) {
            DiskOrder diskOrder = new DiskOrder(job[0], job[1]);
            list.add(diskOrder);
            linkedList.add(diskOrder);
        }

        int processTime = 0;

        do {
            if (linkedList.size() > 0) {
                processTime = putWaitingOrder(processTime, linkedList, processQueue);
            }

            DiskOrder diskOrder = processQueue.poll();
            
            System.out.println(diskOrder.orderTime + ", " + diskOrder.processTime);

            diskOrder.startTime = processTime;
            processTime += diskOrder.processTime;            
        } while (!processQueue.isEmpty() || !linkedList.isEmpty());

        int sum = 0;            
        for (DiskOrder order : list) {
            sum += order.getResultTime();
        }
        
        return sum / list.size();
    }

    private int putWaitingOrder(int processTime, LinkedList<DiskOrder> linkedList, PriorityQueue<DiskOrder> processQueue) {
        
        Iterator<DiskOrder> i = linkedList.iterator();

        while(i.hasNext()) {
            DiskOrder diskOrder = i.next();

            if (processTime >= diskOrder.orderTime) {
                processQueue.add(diskOrder);
                i.remove();
            }
        }

        if (!linkedList.isEmpty() && processQueue.isEmpty()) {
            processTime = getMinOrderTime(linkedList);
            putWaitingOrder(processTime, linkedList, processQueue);
        }

        return processTime;
    }

    private int getMinOrderTime(LinkedList<DiskOrder> linkedList) {
        int minTime = linkedList.getFirst().orderTime;

        for (DiskOrder diskOrder : linkedList) {
            if (minTime > diskOrder.orderTime) {
                minTime = diskOrder.orderTime;
            }
        }

        return minTime;
    }
}

class DiskOrder implements Comparable<DiskOrder>{

    int orderTime = 0;
    int startTime = 0;
    int processTime = 0;

    public DiskOrder (int order, int processTime) {
        this.orderTime = order;
        this.processTime = processTime;
    }

    @Override
    public int compareTo(DiskOrder o) {
        return this.processTime < o.processTime ? -1 : 1;
    }

    public int getResultTime() {
        return startTime + processTime - orderTime;
    }
}

