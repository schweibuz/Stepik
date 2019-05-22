package com.company.stepik.functionalProg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.*;

class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 5;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Function<Integer, String > function = x -> String.valueOf(x.hashCode());
        Supplier<Integer> supplier = () -> new Integer(5);
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        BinaryOperator<Integer> binaryOperator = (x,y) -> x * y;

        MyPredicate<Integer> myPredicate = x -> System.out.println(x);

        myPredicate.apply(5);
        System.out.println(predicate.test(6));
        consumer.accept(3);
        System.out.println(function.apply(9));
        System.out.println(supplier.get());
        System.out.println(binaryOperator.apply(3,3));

        //lambda example
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        Runnable runnable1 = () -> System.out.println("run1");
        String s = "action";
        ActionListener actionListener = (ActionEvent event) -> System.out.println(s);

        Moy moy = new Moy();
        moy.apply(324);
        System.out.println(moy.equals(324));
    }
}

@FunctionalInterface
interface MyPredicate<T> {
    void apply(T t);
    boolean equals(Object o);
}

class Moy implements MyPredicate {
    @Override
    public void apply(Object o) {

    }
}