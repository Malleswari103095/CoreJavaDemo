package com.corejavademo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrencyExample {

    public static void main()
    {

        ArrayList<Integer> list = new ArrayList(Arrays.asList(new Integer[]
                {1452, 6854, 8741, 6542, 3845}));

        list.add(123);

        try {
            list.stream().map(el -> {
                list.add(8457);      //This will throw ConcurrentModificationException
                return el;
            });

            list.stream().forEach(el -> {
                list.add(8457);      //This will throw ConcurrentModificationException
            });

            list.forEach(el -> {
                list.add(8457);      //This will throw ConcurrentModificationException
            });

            for(Integer el: list) {
                list.add(8457);      //This will throw ConcurrentModificationException
            }

            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Integer el = it.next();
                list.add(8457);      //This will throw ConcurrentModificationException
            }
        } catch(java.util.ConcurrentModificationException ex) {
            System.out.println("failed with:" + ex + "\r\n");
        }

        concHashMap();
    }

    //Taken from http://javaconceptoftheday.com/fail-fast-and-fail-safe-iterators-in-java-with-examples/
    public static void concHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THREE", 3);
        map.put("FOUR", 4);

        Iterator<String> it = map.keySet().iterator();
        // Iterator returned by ConcurrentHashMap is a fail-safe iterator.

        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println(key+" : "+map.get(key));
            map.put("FIVE", 5);     //This will not be reflected in the Iterator
        }
        System.out.println("Final length of ConcurrentHashMap = " + map.size());

        copyOnWriteArrayList();
    }

    public static void copyOnWriteArrayList() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(new Integer[]
                {1,2,3,4}));

        Iterator<Integer> it = list.iterator();
        // Iterator returned by CopyOnWriteArrayList is a fail-safe iterator.

        while (it.hasNext()) {
            Integer el = it.next();
            System.out.println(el);
            list.add(5);
        }
        System.out.println("Final length of CopyOnWriteArrayList = " + list.size());
        System.out.println("CopyOnWriteArrayList value s= " + list);
    }


    public static void main(String[] args) {

        new ConcurrencyExample().main();
    }

}