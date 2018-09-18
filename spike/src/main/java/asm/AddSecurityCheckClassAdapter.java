package asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-06
 */
public class AddSecurityCheckClassAdapter extends ClassAdapter{
    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature,
            String[] exceptions) {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature,exceptions);
            MethodVisitor wrappedMv = mv;
            if (mv != null) {
                // 对于 "operation" 方法
                if (name.equals("operation")) {
                    // 使用自定义 MethodVisitor，实际改写方法内容
                    wrappedMv = new AddSecurityCheckMethodAdapter(mv);
                }
            }
            return wrappedMv;
        }
}
