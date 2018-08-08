/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-08
 */
public class TestThreadYield {

    public static void main(String[] args) {
        long i = 0;
        long startTime = System.currentTimeMillis();
        while (true) {
            Thread.yield();
            if (i % 1000 == 0) {
                System.out.println(i);
            }
            i++;
            if (i >= Integer.MAX_VALUE) {
                break;
            }
        }
        System.out.println("消耗时间:" + (System.currentTimeMillis() - startTime));
    }

}
