package com.lisong.question1;

import java.util.concurrent.TimeUnit;

/**
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Test {

    public static void main(String[] args) {
        Container container = new Container();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                if (container.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("size is 5");
                lock.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 11; i++) {
                    container.add(new Object());
                    System.out.println("add " + i);
                    if(i == 5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
