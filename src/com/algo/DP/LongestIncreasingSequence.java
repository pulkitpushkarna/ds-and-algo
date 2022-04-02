package com.algo.DP;

import java.util.Arrays;

public class LongestIncreasingSequence {

    public static void main(String[] args) {
        int[] arr = {1, 45, 6, 28, 23, 98, 102, 3, 200, 2};
        System.out.println(findLIS(arr));
    }


    public static int findLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxo = 0;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
                dp[i] = max + 1;
            }
            if (dp[i] > maxo) {
                maxo = dp[i];
            }
            System.out.println(Arrays.toString(dp));
        }
        return maxo;
    }
}
