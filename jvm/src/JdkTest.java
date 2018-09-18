import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-27
 */
public class JdkTest {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        JdkTest traceTest = new JdkTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int a = (int)Math.round(Math.random() * 1000);
        int b = (int)Math.round(Math.random() * 1000);
        System.out.println(traceTest.add(a, b));
    }
}