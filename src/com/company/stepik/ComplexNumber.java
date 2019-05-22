package com.company.stepik;

import java.util.Objects;

final class ComplexNumber {

    public static void main(String[] args) {
        ComplexNumber complex = new ComplexNumber(5453.323, 76895.231);
        ComplexNumber complex2 = new ComplexNumber(3453.4, 134134.234);

        System.out.println(complex.toString());
        System.out.println(complex.equals(complex));
        System.out.println(complex.equals(34234.234));
        System.out.println(complex.equals(complex2));
        System.out.println(complex2.equals(complex));
        System.out.println(complex.hashCode());
        System.out.println(complex2.hashCode());
    }

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

}