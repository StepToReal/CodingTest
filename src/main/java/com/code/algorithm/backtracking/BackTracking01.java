package com.code.algorithm.backtracking;

public class BackTracking01 {
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};

        for (int i = 1; i < nums.length; i++) {
            visited = new boolean[nums.length];
            backTracking(nums, i, 0, nums[i] + "");
        }

        System.out.println(sb);
    }

    private static void backTracking(int[] arr, int current, int count, String seq) {
        if (count == arr.length - 2) {
            sb.append(seq).append(NEW_LINE);
            return;
        }

        if (visited[current]) return;

        visited[current] = true;

        for (int next = 1; next < arr.length; next++) {
            if (visited[next]) continue;

            backTracking(arr, next, count + 1, seq + SPACE + arr[next]);
            visited[next] = false;
        }
    }
}
