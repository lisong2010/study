import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-09
 */
public class MyDynamicProxy {

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy
                .newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(),
                        new MyInvocationHandler(new HelloImpl()));
        hello.sayHello();
    }
}

interface Hello {

    void sayHello();
}

class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Hello hello;

    public MyInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("invoke start");
        Object result = method.invoke(this.hello, args);
        return result;
    }
}


