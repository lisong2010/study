package proxy;

import annotation.CacheLock;
import annotation.LockedComplexObject;
import annotation.LockedObject;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import lock.RedisLock;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-05
 */
public class CacheLockInterceptor implements InvocationHandler{
    public static int ERROR_COUNT = 0;
    private Object proxied;

    public CacheLockInterceptor(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);
        if(null == cacheLock) {
            System.out.println("no cacheLock annotation");
        }
        Annotation[][] annotations = method.getParameterAnnotations();
        Object lockedObject = getLocakedObject(annotations, args);
        String objectvalue = lockedObject.toString();

        RedisLock lock = new RedisLock(cacheLock.lockedPrefix(), objectvalue);

        boolean result = lock.lock(cacheLock.timeOut(), cacheLock.expireTime());

        if(!result) {
            ERROR_COUNT += 1;
            throw new IllegalArgumentException("get lock fail");
        }
        try {
            return method.invoke(proxied, args);
        } finally {
            lock.unlock();
        }
//        return null;
    }

    private Object getLocakedObject(Annotation[][] annotations, Object[] args) {
        if(null == args || args.length ==0) {
            throw new IllegalArgumentException("方法参数为空");
        }

        if(null == annotations || annotations.length == 0) {
            throw new IllegalArgumentException("没有被注解的参数");
        }

        int index = -1;
        for(int i = 0; i < annotations.length; i++) {
            for (int j =0; j < annotations[i].length; j++) {
                if(annotations[i][j] instanceof LockedComplexObject) {
                    index = i;
                    try {
                        return args[i].getClass().getField(((LockedComplexObject)annotations[i][j]).field());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
                if(annotations[i][j] instanceof LockedObject){
                    index = i;
                    break;
                }
            }
            //找到第一个后直接break，不支持多参数加锁
            if(index != -1){
                break;
            }
        }

        if(index == -1){
            throw new IllegalArgumentException("请指定被锁定参数");
        }

        return args[index];
    }
}
