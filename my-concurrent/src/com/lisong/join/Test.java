package com.lisong.join;

import java.util.concurrent.TimeUnit;

/**
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("i is " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t.start();
        System.out.println("start");
        t.join();
        System.out.println("end");
    }
}
