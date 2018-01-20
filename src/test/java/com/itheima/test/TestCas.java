package com.itheima.test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCas {
    public static AtomicInteger count = new AtomicInteger(0);
//    public static int count=0;
    public static void main(String[] args) {
        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 1000; j++) {
                        synchronized (TestCas.class) {
                            count.incrementAndGet();
                        }
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count>>"+count);
    }
}
