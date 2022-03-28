package com.algo.DP;

public class KM3 {
    public static void main(String[] args) {
//        int arr[] = {1, 4, 2, 3, 7};
        int arr[] = {5, 3, 4, 11, 2};
        int cache[] = new int[arr.length + 1];
        System.out.println(rob(arr, arr.length - 1));
        System.out.println(rob(arr, arr.length - 1, cache));
        System.out.println(robTabulation(arr));
        System.out.println(robTabEffec(arr));
    }
//    int arr[] = {5, 3, 4, 11, 2};

    public static int robTabEffec(int[] arr) {
        int prev1 = arr[0];
        int prev2 = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            System.out.println("prev1>>>"+prev1);
            System.out.println("prev2>>>"+prev2);
            System.out.println("a[i]>>>"+arr[i]);
            int temp = prev2;
            prev2 = Math.max(prev1 + arr[i], prev2);
            prev1 = temp;
        }
        return prev2;
    }

    static int robTabulation(int[] arr) {
        int[] cache = new int[arr.length + 1];
        cache[0] = arr[0];
        cache[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            System.out.println("a[i]>>" + arr[i]);
            System.out.println("cache[i-1]>>>>" + cache[i - 1]);
            System.out.println("cache[i-2]>>>>" + cache[i - 2]);
            cache[i] = Math.max(arr[i] + cache[i - 2], cache[i - 1]);
            System.out.println("cache[i]>>>>" + cache[i]);
        }
        return cache[arr.length - 1];
    }

    public static int rob(int[] arr, int i, int[] cache) {
        if (i < 0) {
            return 0;
        }
        if (cache[i] != 0) {
            return cache[i];
        }
        int ith_house_selected = arr[i] + rob(arr, i - 2);
        int ith_house_not_selected = rob(arr, i - 1);
        return cache[i] = Math.max(ith_house_selected, ith_house_not_selected);
    }

    public static int rob(int[] arr, int i) {
        if (i < 0) {
            return 0;
        }
        int ith_house_selected = arr[i] + rob(arr, i - 2);
        int ith_house_not_selected = rob(arr, i - 1);
        return Math.max(ith_house_selected, ith_house_not_selected);
    }
}
