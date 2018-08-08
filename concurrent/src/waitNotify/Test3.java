package waitNotify;

import java.util.concurrent.TimeUnit;

/**
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-26
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("0-----0");
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.start();
    }
}
