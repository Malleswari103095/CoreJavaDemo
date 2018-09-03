package com.corejavademo.collections;

import java.util.*;


public class SynchronisedListExample {

//    private List<Integer> integerList = new ArrayList<>();
//    private List<Integer> integerList = new Vector<>();
     private List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());

    private void calculate() {
        for (int i = 0; i < 1000; i++) {
            try { integerList.add(new Random().nextInt(100)); }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void calculate2() {
        for (int i = 0; i < 1000; i++) {
            try { integerList.add(new Random().nextInt(100)); }
            catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    public void process() {
        Long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> calculate());
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                calculate2();
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
        System.out.println("List size: " + integerList.size());
    }

    public static void main(String[] args) {

        new SynchronisedListExample().process();

    }

}

