/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-09
 */
public class Singleton {

    private Singleton() {

    }

    private volatile static Singleton singleton;

    public static Singleton newInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton != null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
