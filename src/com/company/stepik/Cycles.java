package com.company.stepik;

import java.math.BigInteger;
import java.util.Arrays;
import java.lang.System;

class Cycles {
    int[] array1 = new int[]{3, 5, 6, 7, 8, 10, 12, 16};
    int[] array2 = new int[]{2, 4, 5, 9, 11, 13, 14, 18};

    public static void main(String[] args) {
        Cycles cycles = new Cycles();
        System.out.println(cycles.factorial(15));

        System.out.println(Arrays.toString(cycles.mergeArrays(cycles.array1, cycles.array2)));

    }


    public static BigInteger factorial(int value) {
        BigInteger bg = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) {
            bg = bg.multiply(BigInteger.valueOf(i));
        }
        return bg;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] mas = new int[a1.length + a2.length];
        int a1counter = 0;
        int a2counter = 0;
        for (int i = 0; i < mas.length; i++) {
            if (a1counter < a1.length && a2counter < a2.length) {
                if (a1[a1counter] < a2[a2counter]) {
                    mas[i] = a1[a1counter];
                    a1counter++;
                } else {
                    mas[i] = a2[a2counter];
                    a2counter++;
                }
            } else if (a1counter < a1.length) {
                mas[i] = a1[a1counter];
                a1counter++;
            } else {
                mas[i] = a2[a2counter];
                a2counter++;
            }
        }
        return mas;
    }
}
