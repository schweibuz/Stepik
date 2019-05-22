package com.company.stepik.generics;

import java.util.Optional;
import java.util.stream.Stream;

class OptionalTest {

    public static void main(String[] args) {

//        Stream.of(1).min().isPresent();     //return Optional
        Optional<String> optional = getO();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

    }

    static Optional<String> getO() {
        if (false) {
            return Optional.of("Hello");
        }
        return Optional.empty();    // =null
    }
}
