package cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 * 在  await 处 等待给定线程数量全部执行 后再执行
 * @author lisong(OF2016)
 *         company qianmi.com
 *         Date    2018-05-25
 */
public class Test {

    public static void main(String[] args) {
        List list = new ArrayList();

        CyclicBarrier cyclicbarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            Thread thread = new Thread(() -> {
                long time = (long) (Math.random() * 4000);
                System.out.println("into thread " + j + ", " + time);

                try {
                    if(j == 9) {
                        Thread.sleep(30000);
                        cyclicbarrier.await();
                    } else {
                        Thread.sleep(time);
                        cyclicbarrier.await();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("end thread " + j);
            });
            list.add(thread);
            thread.start();
        }
    }
}
