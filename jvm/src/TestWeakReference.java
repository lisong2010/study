import java.lang.ref.WeakReference;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-13
 */
public class TestWeakReference {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
        super.finalize();
    }


    public static void main(String[] args) {
        TestWeakReference testWeakReference = new TestWeakReference();
        System.out.println(testWeakReference.toString());
        WeakReference weakReference = new WeakReference(testWeakReference);


        testWeakReference = null;
        System.gc();

        if(weakReference.get() == null) {
            System.out.println("弱引用对象被清除");
        } else {
            System.out.println("弱引用对象未被清除, 其信息是：" + weakReference.get().toString());
        }
    }
}
