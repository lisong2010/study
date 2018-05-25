package waitNotify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Test2 {

    public static void main(String[] args) {
        Container container = new Container();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            if (container.size() != 5) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("size is 5");
        }).start();

        new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                container.add(new Object());
                System.out.println("add " + i);
                if (i == 5) {
                    countDownLatch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
