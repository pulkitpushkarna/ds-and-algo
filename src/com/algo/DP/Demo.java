package com.algo.DP;


//series 0 1 1 2 3 5 8 13 21 34
public class Demo {

    public static void main(String[] args) {
        int n = 45;
        int[] arr = new int[n + 1];
        System.out.println(fib2(n, arr));
//        System.out.println(fib1(n));
    }


    static int fib1(int n) {
        if (n < 2) {
            return n;
        }
            return fib1(n - 1) + fib1(n - 2);

    }

    static int fib2(int n, int[] arr) {
        if (n < 2) {
            return n;
        } else if (arr[n] != 0) {
            return arr[n];
        } else {
            return arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);
        }
    }
}
