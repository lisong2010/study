import java.lang.ref.SoftReference;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-13
 */
public class TestSoftReference {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }


    public static void main(String[] args) {
        TestWeakReference testWeakReference = new TestWeakReference();
        System.out.println(testWeakReference.toString());
        SoftReference weakReference = new SoftReference(testWeakReference);

        testWeakReference = null;
        System.gc();

        if(weakReference.get() == null) {
            System.out.println("弱引用对象被清除");
        } else {
            System.out.println("弱引用对象未被清除, 其信息是：" + weakReference.get().toString());
        }
    }
}
