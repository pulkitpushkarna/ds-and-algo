package com.algo.DP;

public class KM1 {

    // 0 1 1 2 3 5 8 13

    public static void main(String[] args) {
        int n = 5;
        int[] cache = new int[n + 1];
//        System.out.println(fib(n));
        System.out.println(fib(n, cache));
        System.out.println(fibTabulation(n));
        System.out.println(fibTabEffec(n));
    }

    public static int fibTabEffec(int n) {
        int first = 0;
        int second = 1;
        int sum = 0;
        for (int i = 2; i < n + 1; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static int fibTabulation(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static int fib(int n, int[] cache) {
        if (n < 2) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        return cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
