/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong;

/**
 *
 * @author song.li
 * @version $Id: Echo.java, v 0.1 2018-10-24 09:29 song.li Exp $$
 */
public class Echo implements EchoMBean{

    @Override
    public void print(String name) {
        System.out.println("hello " + name);
    }
}