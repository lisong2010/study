package thread;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-10
 */
public class TestThreadCount {

    public static void main(String[] args) {
        System.out.println("Hello world");

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup t;
        while ((t = threadGroup.getParent()) != null) {
            threadGroup = t;
        }
        System.out.println(threadGroup);
        System.out.println(threadGroup.activeCount());

        int nowThreads = threadGroup.activeCount();
        Thread[] lstThreads = new Thread[nowThreads];
        threadGroup.enumerate(lstThreads);

        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number：" + i + " = " + lstThreads[i].getName());
        }
    }

}
