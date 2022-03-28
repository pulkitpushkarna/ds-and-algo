package com.algo.DP;

import java.util.Arrays;
//abaabaabaa
public class Dummy {


    public static void main(String[] args) {
        String s = "aba";
        int n = 10;
        long numberOfAs = s.chars().filter(ch-> ch =='a').count();
        System.out.println(numberOfAs);
        numberOfAs = numberOfAs * (n / s.length());
        System.out.println(numberOfAs);

    }
}
