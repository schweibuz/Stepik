package com.company.stepik.collections;
import java.util.*;

class Listest {
    public static void main(String[] args) {
        Iterator iterator = someMethod().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        Collection<?> collection = null;
//        collection.iterator();
//        collection.clear();
//        Object o = "sdf";
//        collection.remove(o);
////        collection.add(o);
//        collection.toArray();
////        collection.addAll(Arrays.asList(o));
//        collection.contains(o);
//        collection.size();

        Set<String> set = new LinkedHashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        Iterator<String> iterator2 = set.iterator();
        while (iterator2.hasNext())
            System.out.println(iterator2.next());
    }

    static List someMethod() {
        List<String> list2 = new ArrayList<String>();
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("aaa");

        Set<String> set = new LinkedHashSet<>(list);

        List<String> listWithoutDups = new ArrayList<>(set);
        return listWithoutDups;
    }
}
