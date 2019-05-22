package com.company.stepik.streams;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamTask {
    public static void main(String[] args) {

        IntStream stream = pseudoRandomStream(13);
        int[] mas = stream.limit(20).toArray();
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s ", mas[i]);
        }

    }

    public static IntStream pseudoRandomStream(int seed) {
        IntStream stream = IntStream.iterate(seed, n -> n * n / 10 % 1000);
        return stream;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {


        // your implementation here
    }
}
