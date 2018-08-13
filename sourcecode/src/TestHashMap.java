import java.util.Map;
import java.util.TreeMap;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-06
 */
public class TestHashMap {

    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put("student1", "dora");
        map.put("student", "dora");
        map.put("student2", "dora");
        map.put("student3", "dora");
        map.put("student4", "dora");
        map.put("student5", "dora");
        System.out.println(map);
        System.out.println(1 << 30 >>> 16 ); //-1879145925
        System.out.println(1 << 30 >> 16 );
        System.out.println(1 << 30);
        System.out.println(1 << 63);
        System.out.println(1 << 32);
        System.out.println(~11);

    }
}
