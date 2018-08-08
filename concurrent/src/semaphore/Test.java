package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  信号量
 *  当现成运行数等于信号量数量时，其他线程等待
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(String.format("start ...%s, %s", j, System.currentTimeMillis()));
                    TimeUnit.SECONDS.sleep(2);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("end ...%s, %s", j, System.currentTimeMillis()));
            }).start();
        }
    }
}
