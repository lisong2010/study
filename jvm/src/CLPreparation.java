/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-02
 */
public class CLPreparation {
    public static int a = 100;

    public static final int INT_CONSTANT = 1000;

    public static final Integer INTEGER_CONSTANT = Integer.valueOf(100000);

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
