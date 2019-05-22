package com.company.stepik;

import java.util.function.DoubleUnaryOperator;

class Integrate {
    public static void main(String[] args) {

        System.out.println(integrate(x -> 1,0,10));
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double s = 0;
        double h = Math.pow(10, -6);
        int i;
        int n = (int) ((b - a) / h);
        System.out.println(n);
        for (i = 0; i < n; i++) {
            s += f.applyAsDouble(a + h * (i + 0.5));
        }
        s *= h;
        return s;
    }
}
