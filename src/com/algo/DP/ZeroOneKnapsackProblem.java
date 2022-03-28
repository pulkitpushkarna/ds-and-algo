package com.algo.DP;

public class ZeroOneKnapsackProblem {
    
    public static void main(String[] args) {
        int[] value = {150, 300, 200};
        int[] weight = {1, 4, 3};
        int capacity = 4;
        System.out.println(zeroOneKnapsackProblem(value,weight,capacity));
    }

    public static int zeroOneKnapsackProblem(int[] value, int[] weight, int capacity) {
        int n = value.length;
        int[][] memo = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (weight[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                }else{
                    memo[i][j]=Math.max(value[i-1]+ memo[i-1][j-weight[i-1]], memo[i-1][j]);
                }
            }
        }
        return memo[n][capacity];
    }
}
