package com.algo.DP;

public class HouseRobberProblem {

    public static void main(String[] args) {

        int[] arr = {2, 45, 8, 7, 98, 24};
        int[] cache = new int[arr.length + 1];
        System.out.println(rob(arr, arr.length - 1));
        System.out.println(robCache(arr, arr.length - 1, cache));
        System.out.println(houseRobberBottomUpSolution(arr,cache));
        System.out.println(houseRobberBottomUpSolutionWithoutCache(arr));

    }

    static int rob(int[] arr, int n) {

        if (n < 0) {
            return 0;
        }
//        System.out.println("n---->>>>" + n);
        int ith_house_selected = rob(arr, n - 2) + arr[n];
        int ith_house_not_selected = rob(arr, n - 1);
        return Math.max(ith_house_selected, ith_house_not_selected);
    }

    static int robCache(int[] arr, int n, int[] cache) {
        if (n < 0) {
            return 0;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int ith_house_selected = robCache(arr, n - 2, cache) + arr[n];
        int ith_house_not_selected = robCache(arr, n - 1, cache);
        return cache[n] = Math.max(ith_house_selected, ith_house_not_selected);
    }

    static int houseRobberBottomUpSolution(int[] arr, int[] cache) {
        cache[0] = arr[0];
        cache[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            cache[i]=Math.max(cache[i-1],cache[i-2]+arr[i]);
        }
        return cache[arr.length-1];
    }

    static int houseRobberBottomUpSolutionWithoutCache(int[] arr) {
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + arr[i], prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
