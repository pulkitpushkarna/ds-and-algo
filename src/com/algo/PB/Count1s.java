package com.algo.PB;

public class Count1s {

    public static void main(String[] args) {
        int count = 0;
        int number = 211184;
        while (number != 0) {
            number = number & (number << 1);
            count++;
        }
        System.out.println(count);
    }
}
