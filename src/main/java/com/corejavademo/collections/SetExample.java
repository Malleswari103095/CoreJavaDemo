package com.corejavademo.collections;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {

        Random r = new Random();

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> linkedSet = new LinkedHashSet<>();

        // HashSet add
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            hashSet.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("HashSet: " + duration/1000000);

        // TreeSet add
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            treeSet.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("TreeSet: " + duration/1000000);

        // LinkedHashSet add
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedSet.add(i);
        }
        // end time
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedHashSet: " + duration/1000000);

    }
}
