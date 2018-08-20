import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-15
 */
public class TestClassInfo {

    public static void main(String[] args) {
        Method[] methods = HashMap.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toString());
        }
    }

}
