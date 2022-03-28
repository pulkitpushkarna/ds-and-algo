package com.algo.DP;

public class EfficientFibonacci {
    public static void main(String[] args) {
        int n = 4;
        int first = 0, second = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        System.out.println(sum);

    }
}
