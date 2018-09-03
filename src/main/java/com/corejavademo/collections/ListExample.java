package com.corejavademo.collections;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random rand = new Random();

        // ArrayList add
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration/1000000);

        // LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration/1000000);

        // ArrayList get
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            int index = rand.nextInt(99999) + 1;
            arrayList.get(index);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration/1000000);

        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            int index = rand.nextInt(99999) + 1;
            linkedList.get(index);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration/1000000);

        List<Integer> linkedListCopy = linkedList;
        List<Integer> arrayListCopy = arrayList;

        // ArrayList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >=0; i--) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration/1000000);

        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >=0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration/1000000);


        // ArrayList remove with ListIterator
        ListIterator<Integer> arrayListIterator = arrayListCopy.listIterator();

        startTime = System.nanoTime();
        while (arrayListIterator.hasNext()) {
            arrayListIterator.next();
            arrayListIterator.remove();
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove using ListIterator:  " + duration/1000000);


        // LinkedList remove with ListIterator
        ListIterator<Integer> linkedListIterator = linkedListCopy.listIterator();

        startTime = System.nanoTime();
        while (linkedListIterator.hasNext()) {
            linkedListIterator.next();
            linkedListIterator.remove();
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove using ListIterator:  " + duration/1000000);

    }
}
