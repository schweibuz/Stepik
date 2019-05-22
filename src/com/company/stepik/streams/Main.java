package com.company.stepik.streams;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        System.out.println();

//        Stream<String> stream = list.stream();
//        stream.forEach(x -> System.out.println(x));
//        stream = list.stream();       //running stream after applying terminal operation from previous step
//        stream.forEach(x -> System.out.println(x));

        list.stream().forEach(x -> System.out.println(x));

        list.stream().filter(x -> x.equals("one"));
//      -------------------------
        list.stream().filter(x -> {
            System.out.println(x);
            return x.equals("one");
        }).count(); //lazy//eager

//      -------------------------
        Set<String> set = list.stream().filter(x -> x.equals("one")).collect(Collectors.toSet());
        System.out.println(set.toString());
//      -------------------------
        List<String> list2 = Stream.of("one", "two", "three").map(
                x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(list2.toString());
//      -------------------------
        Stream.of(asList("one", "two"), asList("three", "four")).flatMap(x -> x.stream());
//      -------------------------
        int value = Stream.of(1, 2).min(Comparator.comparing(x -> x)).get();
        int value2 = Stream.of(1, 2).max(Comparator.comparing(x -> x)).get();
        System.out.println("min " + value + "; max " + value2);
//      -------------------------
        int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(count);

        int accomulator = 0;
        for (int element : new int[]{1, 2, 3}) {
            accomulator += element;
        }
        System.out.println(accomulator);
//      -------------------------
        Stream.of("one", "two").sorted().collect(Collectors.toList());
        Stream.of("one", "two").limit(1).collect(Collectors.toList());
        Stream.of("one", "two").distinct().collect(Collectors.toList());
        Stream.of("one", "two").skip(1).collect(Collectors.toList());
        System.out.println(Stream.of("one", "two").filter(x -> x.equals("one")).findAny().get()); //return Optional
        System.out.println(Stream.of("one", "two").filter(x -> x.equals("one")).findAny().isPresent());
        System.out.println(Stream.of(1, 2, 3).mapToInt(x -> x).sum());
        System.out.println(Stream.of(1, 2, 3).count());
        System.out.println(Stream.of("one", "two").peek(x -> x.toUpperCase()).findFirst().get());
//      -------------------------
        IntStream intStream = Stream.of(1, 2).mapToInt(x -> x);
        System.out.println(intStream.summaryStatistics().getAverage());
//      -------------------------
        int sum = IntStream.iterate(1, n -> n + 1)
                .filter(n -> n % 5 == 0 && n % 2 != 0)
                .limit(10)
                .map(n -> n * n)
                .sum();
        System.out.println(sum);
//      -------------------------
        DoubleStream randomNumbers = DoubleStream.generate(Math::random)   //Supplier(interface with singular method "get")
                .limit(10);
        randomNumbers.forEach(s -> System.out.print(s + " "));

        System.out.println();
        IntStream integers = IntStream.iterate(0, n -> n + 1)
                .limit(100);
        integers.forEach(s -> System.out.print(s + " "));

        System.out.println();
        IntStream smallIntegers = IntStream.range(0, 100);
        smallIntegers.forEach(s -> System.out.print(s + "; "));

        System.out.println();
        IntStream stream = IntStream.of(3241, 332, 332, 3241, 200, 3324, 333);
        stream.filter(n -> n > 100)
                .mapToObj(Integer::toString)
                .flatMapToInt(s -> s.chars())
//                .peek(System.out::println)
                .distinct()
                .sorted()
                .skip(1)
                .limit(2)
                .peek(System.out::println).count(); //elements remaining in stream (Terminal operation)
//      -------------------------
        List<String> listt = new ArrayList<>();
        listt.add("Geeks");
        listt.add("For");
        listt.add("GEEKS");
        // call the static method
        // using double colon operator
        listt.forEach(Main::someFunction);  //terminal operation
//      -------------------------
        Stream<String> stream1 = Stream.of("One", "Tu", "Four", "Eight");
        Optional<String> minString = stream1.min(Comparator.comparing(String::length, Integer::compare));//terminal
        System.out.println(minString.toString());
//      -------------------------
        int a = 33;
        System.out.printf("factorial %d: %s %n", a, factorial(a).toString());
//      -------------------------
        System.out.println(isPalindrome("Sos"));

    }

    static void someFunction(String s) {
        System.out.println(s);
    }

    public static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n)     //set of numbers
                .mapToObj(i -> BigInteger.valueOf(i))     //to BigInteger
                .reduce(BigInteger.ONE, BigInteger::multiply);  //calculate
    }


    public static boolean isPalindrome(String s) {
        StringBuilder leftToRight = new StringBuilder();

        s.chars().filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(leftToRight::appendCodePoint); //save result to stringBuilder

        StringBuilder rightToleft = new StringBuilder(leftToRight).reverse();

        return leftToRight.toString()
                .equals(rightToleft.toString());
    }
}