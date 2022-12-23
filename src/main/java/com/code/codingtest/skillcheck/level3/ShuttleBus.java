package com.code.codingtest.skillcheck.level3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuttleBus {
    public static void main(String[] args) {

    }

    public String solution(int busAmount, int interval, int capacity, String[] timetable) {
        LocalTime answer = null;
        List<LocalTime> crews = new ArrayList<>();
        List<Bus> busList = new ArrayList<>();
        LocalTime firstBusTime = LocalTime.of(9, 0);

        for (int i = 0; i < busAmount; i++) {
            Bus bus = new Bus(firstBusTime.plusMinutes(i * interval), capacity);
            busList.add(bus);
        }

        Arrays.sort(timetable);

        for (String time : timetable) {
            String[] timeElement = time.split(":");
            LocalTime crewTime = LocalTime.of(Integer.parseInt(timeElement[0]), Integer.parseInt(timeElement[1]));

            crews.add(crewTime);
        }

        int boardCrewIndex = 0;
        for (Bus bus : busList) {
            for (int i = boardCrewIndex; i < crews.size(); i++) {
                LocalTime crew = crews.get(i);

                if (crew.isAfter(bus.getStartTime()) || bus.isFull()) {
                    boardCrewIndex = i;
                    break;
                } else {
                    bus.addPassenger(crew);
                }
            }
        }

        Bus lastBus = busList.get(busAmount - 1);
        answer = lastBus.getStartTime();

        if (lastBus.isFull()) {
            answer = lastBus.getBoardPassengers().get(capacity - 1).minusMinutes(1);
        }

        return answer.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}

class Bus {
    private LocalTime startTime;
    private int capacity;
    private List<LocalTime> boardPassengers;

    public Bus(LocalTime startTime, int capacity) {
        this.startTime = startTime;
        this.capacity = capacity;
        boardPassengers = new ArrayList<>();
    }

    public boolean isFull() {
        return boardPassengers.size() >= capacity;
    }

    public void addPassenger(LocalTime time) {
        if (!isFull()) {
            boardPassengers.add(time);
        }
    }

    public List<LocalTime> getBoardPassengers() {
        return boardPassengers;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
}