package com.company.stepik.collections;

import java.util.*;

class SymmetricDivision {
    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; i < 5; i++) {
            set.add(i);
        }
        Set set2 = new HashSet();
        for (int i = 2; i < 7; i++) {
            set2.add(i);
        }
        Iterator iterator = symmetricDifference(set, set2).iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set set3 = new HashSet();
        Set set4 = new HashSet();
        set3.addAll(set1);
        set3.removeAll(set2);
        set4.addAll(set2);
        set4.removeAll(set1);
        set3.addAll(set4);

        return set3;
    }
}
