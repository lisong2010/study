package thread;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-10
 */
public class TestThread implements Runnable{
    @Override
    public void run() {
        System.out.println("hello wolrd");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread hello = new Thread(new TestThread());
        hello.start();
        System.out.println("hello wolrd222");
        hello.join();
        System.gc();
        System.out.println("world hello");
    }
}
