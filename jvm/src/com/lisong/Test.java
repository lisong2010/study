/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 *
 * @author song.li
 * @version $Id: Test.java, v 0.1 2018-10-24 09:30 song.li Exp $$
 */
public class Test {

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("com.lisong:type=Echo");

        Echo echo = new Echo();

        mbs.registerMBean(echo, name);

        mbs.invoke(name, "print", new Object[]{"lisong11"}, new String[]{"java.lang.String"});

        Thread.sleep(Long.MAX_VALUE);
    }
}