package sync;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-09
 */
public class ThreadSafeSample {

    private int shareState = 0;

    public void nonShareAction() {
        while (shareState < 100000) {
            synchronized (this) {
                int former = shareState++;
                int latter = shareState;
                if (former != latter - 1) {
                    System.out
                            .println(String.format("former is :%s, latter is :%s", former, latter));
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample tss = new ThreadSafeSample();

        Thread t1 = new Thread(() -> {
            tss.nonShareAction();
        });

        Thread t2 = new Thread(() -> {
            tss.nonShareAction();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
