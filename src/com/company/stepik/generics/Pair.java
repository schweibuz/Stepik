package com.company.stepik.generics;

import java.util.Objects;

class Pair<T, E> {
    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(i);
        System.out.println(s);
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

//        Pair<String, String> pair3 = Pair.of()
    }
    private final T first;
    private final E second;

//    private Pair() {
//        this.first = null;
//        this.second = null;
//    }

    private Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public static <T, E> Pair<T, E> of(T value, E value2) {
        return new Pair<>(value, value2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }


    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}
