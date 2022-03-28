package com.algo.DP;

public class StairCaseProblem {

    public static void main(String[] args) {
        int n = 45;
        int arr[] = new int[n + 1];
//        System.out.println(stairCaseSolution(n));
        System.out.println(stairCaseSolution(n, arr));
        System.out.println(stairCaseBottomUpSolution(n, arr));
        System.out.println(stairCaseBottomUpSolutionWithoutCache(n));
    }

    static int stairCaseSolution(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return stairCaseSolution(n - 1) + stairCaseSolution(n - 2);
    }

    static int stairCaseSolution(int n, int[] arr) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        return arr[n] = stairCaseSolution(n - 1, arr) + stairCaseSolution(n - 2, arr);
    }

    static int stairCaseBottomUpSolution(int n, int[] arr) {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    static int stairCaseBottomUpSolutionWithoutCache(int n) {
        int first = 1, second = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }


}
