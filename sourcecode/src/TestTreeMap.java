import java.lang.reflect.Field;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import sun.misc.Unsafe;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-06
 */
public class TestTreeMap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        TreeMap treeMap = new TreeMap();
//        treeMap.put("b" , "1234");
//        treeMap.put("a", "1234");
//
//        System.out.println(treeMap);
        long startTime = System.currentTimeMillis();
        long j = 0;
        for (int i = 0; i < 2000000000; i++) {
//            j += 4 * i;
            j += i << 3;
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(j);
        System.out.println(new TestTreeMap().hashCode());
        System.out.println(1625635731 ^ 24810);
        System.out.println(24811 & 15);
        System.out.println(24811 % 16);

//        Unsafe u = Unsafe.getUnsafe();
//        System.out.println(u);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.putIfAbsent("a", "a");
        concurrentHashMap.putIfAbsent("b", "b");

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe u = (Unsafe) field.get(null);

        //获得Target实例域value
        Field valueField = ObjectFieldOffsetTest.class.getDeclaredField("value");
        long valueOffset= u.objectFieldOffset(valueField);
        System.out.println(valueOffset);

    }

}
