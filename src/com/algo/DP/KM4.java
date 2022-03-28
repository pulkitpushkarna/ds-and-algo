package com.algo.DP;

public class KM4 {

    public static void main(String[] args) {
//        String str1 = "JavaProgram";
//        String str2 = "JavaLanguage";
        String str1 = "JavaProgrammingLanguage";
        String str2 = "JavaLanguage";
        int m = str1.length();
        int n = str2.length();
        int[][][] cache = new int[m + 1][n + 1][Math.max(m, n) + 1];
//        System.out.println(lcs(str1, str2, m, n, 0));
        System.out.println(lcs(str1, str2, m, n, 0, cache));
        System.out.println(lcs(str1.toCharArray(), str2.toCharArray()));
    }

    public static int lcs(char[] str1, char[] str2) {
        int[][] memo = new int[str1.length][str2.length];
        int max = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (str1[i] == str2[j]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    max = Math.max(max, memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static int lcs(String str1, String str2, int m, int n, int lcsCount, int[][][] cache) {
        if (m <= 0 || n <= 0) {
            return lcsCount;
        }
        if (cache[m][n][lcsCount] != 0) {
            return cache[m][n][lcsCount];
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            lcsCount = lcs(str1, str2, m - 1, n - 1, lcsCount + 1, cache);
        }
        int lcsCount2 = lcs(str1, str2, m, n - 1, 0, cache);
        int lcsCount3 = lcs(str1, str2, m - 1, n, 0, cache);
        return cache[m][n][lcsCount] = Math.max(lcsCount, Math.max(lcsCount2, lcsCount3));
    }

    public static int lcs(String str1, String str2, int m, int n, int lcsCount) {
        if (m <= 0 || n <= 0) {
            return lcsCount;
        }
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            lcsCount = lcs(str1, str2, m - 1, n - 1, lcsCount + 1);
        }
        int lcsCount2 = lcs(str1, str2, m, n - 1, 0);
        int lcsCount3 = lcs(str1, str2, m - 1, n, 0);
        return Math.max(lcsCount, Math.max(lcsCount2, lcsCount3));
    }
}
