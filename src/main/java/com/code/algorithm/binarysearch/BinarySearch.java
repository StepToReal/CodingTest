package com.code.algorithm.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("binary search BackTracking : " + binarySearchBT(arr, 5, arr[0], arr[99]));
        System.out.println("binary search while : " + binarySearchWhile(arr, 5));
    }

    private static int binarySearchBT(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                return binarySearchBT(arr, key, mid + 1, high);
            } else {
                return binarySearchBT(arr, key, low, mid - 1);
            }
        }

        return -1; //탐색실패
    }

    private static int binarySearchWhile(int[] arr, int key) {
        int mid;
        int low = arr[0];
        int high = arr[arr.length - 1];

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
