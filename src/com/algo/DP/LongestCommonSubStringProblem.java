package com.algo.DP;

public class LongestCommonSubStringProblem {

    public static void main(String[] args) {
        String str = "JavaProgrammingLanguage";
        String str2 = "JavaLanguage";
//        String str = "JavaProgram";
//        String str2 = "JavaProgram";
        int m = str.length();
        int n = str2.length();
        int[][][] cache = new int[m + 1][n + 1][Math.max(m, n) + 1];
        System.out.println(longestCommonSubString(str.toCharArray(), str2.toCharArray(), str.length(), str2.length(), 0));
        System.out.println(longestCommonSubStringWithCaching(str.toCharArray(), str2.toCharArray(), str.length(), str2.length(), 0, cache));
        System.out.println(longestCommonSubStringBottomUpSolution(str.toCharArray(), str2.toCharArray(), str.length(), str2.length()));
    }


    static int longestCommonSubStringBottomUpSolution(char[] str1, char[] str2, int m, int n) {
        int result = 0;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (str1[i - 1] == str2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    result = Math.max(memo[i][j], result);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        return result;
    }

    static int longestCommonSubStringWithCaching(char[] str1, char[] str2, int m, int n, int lcsCount, int cache[][][]) {
        if (m <= 0 || n <= 0) {
            return lcsCount;
        }
        if (cache[m][n][lcsCount] != 0) {
            return cache[m][n][lcsCount];
        }
        int lcsCount1 = lcsCount;
        if (str1[m - 1] == str2[n - 1]) {
            lcsCount1 = longestCommonSubStringWithCaching(str1, str2, m - 1, n - 1, lcsCount + 1, cache);
        }
        int lcsCount2 = longestCommonSubStringWithCaching(str1, str2, m, n - 1, 0, cache);
        int lcsCount3 = longestCommonSubStringWithCaching(str1, str2, m - 1, n, 0, cache);
        return cache[m][n][lcsCount] = Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));

    }

    static int longestCommonSubString(char[] str1, char[] str2, int m, int n, int lcsCount) {
        if (m <= 0 || n <= 0) {
            return lcsCount;
        }
        int lcsCount1 = lcsCount;
        if (str1[m - 1] == str2[n - 1]) {
            lcsCount1 = longestCommonSubString(str1, str2, m - 1, n - 1, lcsCount + 1);
        }
        int lcsCount2 = longestCommonSubString(str1, str2, m, n - 1, 0);
        int lcsCount3 = longestCommonSubString(str1, str2, m - 1, n, 0);
        return Math.max(lcsCount1, Math.max(lcsCount2, lcsCount3));
    }
}
