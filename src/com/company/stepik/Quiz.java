package com.company.stepik;

import java.security.MessageDigest;

class Quiz {

    int a = 1_000_000_000;

    public static void main(String[] args) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }

        System.out.println(booleanExpression(false, false, true, true));

        Quiz quiz = new Quiz();

        System.out.println(quiz.a);

        System.out.println(quiz.leapYearCount(800));

        System.out.println(quiz.doubleExpression(0.1, 0.2, 0.3));

        System.out.println(quiz.flipBit(0, 1));

        System.out.println(quiz.charExpression(32));

        System.out.println(quiz.isPowerOfTwo(-4));

        System.out.println("A" + ('\t' + '\u0003'));
        System.out.println('A' + '1' + "2");

        System.out.println(isPalindrome("Madam, I'm Adam!"));

    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return a | b & c & !d;
    }


    public static int leapYearCount(int year) {
        return (year / 4) - (year / 100) + (year / 400);
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << bitIndex - 1);
    }

    public static char charExpression(int a) {
        return (char) ((char) '\\' + a);
    }

    public static boolean isPowerOfTwo(int value) {
        if (value == 0)
            return false;
        int tmp = (int) (Math.log(Math.abs(value)) / Math.log(2));
        if (Math.abs(value) == Math.pow(2, tmp)) {
            return true;
        } else
            return false;
    }

    public static boolean isPalindrome(String text) {
        String str = text;
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        if (str.equals(builder.toString()))
            return true;
        return false;
    }

}
