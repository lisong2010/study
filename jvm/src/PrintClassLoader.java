import com.sun.javafx.util.Logging;
import java.util.ArrayList;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-10
 */
public class PrintClassLoader {
    public void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + PrintClassLoader.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        PrintClassLoader p = new PrintClassLoader();
        p.printClassLoaders();
    }
}
