package com.algo.DP;

public class LongestCommonSubSequenceProblem {

    public static void main(String[] args) {
        String str = "Javaaid";
        String str2 = "Javaid";
        int m = str.length();
        int n = str2.length();
        int[][] cache = new int[m + 1][n + 1];
//        System.out.println(longestCommonSubSequenceRecursiveSolution(str.toCharArray(), str2.toCharArray(), m, n));
//        System.out.println(longestCommonSubSequenceRecursiveSolutionWithCache(str.toCharArray(), str2.toCharArray(), m, n, cache));
        System.out.println(longestCommonSubSequenceBottomUpSolution(str.toCharArray(), str2.toCharArray(), m, n));
    }

    static int longestCommonSubSequenceBottomUpSolution(char[] str1, char[] str2, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (str1[i - 1] == str2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }

    static int longestCommonSubSequenceRecursiveSolutionWithCache(char[] str1, char[] str2, int m, int n, int[][] cache) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (cache[m][n] != 0) {
            return cache[m][n];
        }

        if (str1[m - 1] == str2[n - 1]) {
            return 1 + longestCommonSubSequenceRecursiveSolutionWithCache(str1, str2, m - 1, n - 1, cache);
        }

        return cache[m][n] = Math.max(
                longestCommonSubSequenceRecursiveSolutionWithCache(str1, str2, m, n - 1, cache),
                longestCommonSubSequenceRecursiveSolutionWithCache(str1, str2, m - 1, n, cache)
        );

    }

    static int longestCommonSubSequenceRecursiveSolution(char[] str1, char[] str2, int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (str1[m - 1] == str2[n - 1]) {
            return 1 + longestCommonSubSequenceRecursiveSolution(str1, str2, m - 1, n - 1);
        }
        return Math.max(
                longestCommonSubSequenceRecursiveSolution(str1, str2, m, n - 1),
                longestCommonSubSequenceRecursiveSolution(str1, str2, m - 1, n));

    }

}
