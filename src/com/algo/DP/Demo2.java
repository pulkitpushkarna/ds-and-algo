package com.algo.DP;

public class Demo2 {

    public static void main(String[] args) {
        int n = 4;
        int[] cache = new int[n + 1];
        long l1 = System.nanoTime();
//        System.out.println(stairCase(n));
        long l2 = System.nanoTime();
//        System.out.println("Time 1>>>" + (l2 - l1));
        System.out.println(stairCase(n, cache));
        long l3 = System.nanoTime();
//        System.out.println("Time 2>>>" + (l3 - l2));
        System.out.println(stairCaseTabulation(n));
        System.out.println(stairCaseEffecTabulation(n));
    }

    public static int stairCaseEffecTabulation(int n) {
        int first = 1;
        int second = 1;
        int sum = 0;
        if (n == 1 || n == 0) {
            sum = 1;
        } else {
            for (int i = 2; i < n + 1; i++) {
                sum = first + second;
                first = second;
                second = sum;
            }
        }
        return sum;
    }

    public static int stairCaseTabulation(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        if (n > 0) {
            cache[1] = 1;
            for (int i = 2; i < cache.length; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
        }
        return cache[n];
    }

    public static int stairCase(int n, int[] cache) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        return cache[n] = stairCase(n - 1, cache) + stairCase(n - 2, cache);
    }

    public static int stairCase(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return stairCase(n - 1) + stairCase(n - 2);
    }

}
