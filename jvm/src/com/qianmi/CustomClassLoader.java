package com.qianmi;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-10
 */
public class CustomClassLoader extends ClassLoader{

    public CustomClassLoader() {
        super();
    }

    public Class getClass(String name) {
        byte[] b = getNameFromFtp(name);
        return defineClass(name, b, 0, b.length);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("com.qianmi")) {
            System.out.println("Loading Class from Custom Class Loader");
            return getClass(name);
        }
        return super.loadClass(name);
    }

    private byte[] getNameFromFtp(String name) {
        return null;
    }
}
