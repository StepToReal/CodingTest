package com.code.codingtest.skillcheck.level2;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.Arrays;
import java.util.TreeMap;

public class ParkingFeeCalc {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

//        int[] fees = {1, 461, 1, 10};
//        String[] records = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(new ParkingFeeCalc().solution(fees, records)));
    }

    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees);
        TreeMap<Integer, Car> map = new TreeMap<>();

        for (String record : records) {
            String[] recordElements = record.split(" ");
            String time = recordElements[0];
            int carNumber = Integer.parseInt(recordElements[1]);
            String type = recordElements[2];

            if (map.containsKey(carNumber)) {
                Car car = map.get(carNumber);

                if (type.equals("IN")) {
                    car.setInTime(time);
                } else {
                    car.setOutTime(time);
                }
            } else {
                Car car = new Car(fee, carNumber, time);
                map.put(carNumber, car);
            }
        }

        int[] answer = new int[map.size()];
        int index = 0;

        for (Car car : map.values()) {
            car.setParkingFee();
            answer[index++] = car.parkingFee;
        }


        return answer;
    }
}

class Car {
    Fee priceInfo;
    int number;
    int inTime = -1;
    int outTime;
    int parkingTime;
    int parkingFee;

    public Car(Fee priceInfo, int number, String inTime) {
        this.priceInfo = priceInfo;
        this.number = number;
        setInTime(inTime);
    }

    public void setInTime(String inTime) {
        String[] inTimeArr = inTime.split(":");
        this.inTime = Integer.parseInt(inTimeArr[0]) * 60 + Integer.parseInt(inTimeArr[1]);
    }

    public void setOutTime(String outTime) {
        String[] outTimeArr = outTime.split(":");
        this.outTime = Integer.parseInt(outTimeArr[0]) * 60 + Integer.parseInt(outTimeArr[1]);

        setParkingTime();
    }

    public void setParkingTime() {
        parkingTime += outTime - inTime;
        inTime = -1;
        outTime = 0;
    }

    public void setParkingFee() {
        if (inTime != -1 && outTime == 0) {
            setOutTime("23:59");
        }

        if (parkingTime <= priceInfo.baseTime) {
            parkingFee = priceInfo.basicFee;
        } else {
            int elapsedTime = parkingTime - priceInfo.baseTime;
            int elapsedCount = elapsedTime % priceInfo.unitTime != 0 ?
                    elapsedTime / priceInfo.unitTime + 1 :
                    elapsedTime / priceInfo.unitTime;

            parkingFee = priceInfo.basicFee + (elapsedCount * priceInfo.unitFee);
        }
    }
}

class Fee {
    int basicFee;
    int unitFee;
    int baseTime;
    int unitTime;

    public Fee(int[] fees) {
        baseTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
    }
}