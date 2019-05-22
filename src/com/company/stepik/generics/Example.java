package com.company.stepik.generics;

import java.util.Optional;

class Example<X> {
    public static void main(String[] args) {


    }
    private Object object;

    public void someMethod(Object obj) {
        obj = (X) "SDF";
        obj = new Example<String>();

    }

}

