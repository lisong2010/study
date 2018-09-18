package asm;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-06
 */
public class AddSecurityCheckMethodAdapter extends MethodAdapter {


    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
        super(mv);
    }

    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, SecurityChecker.class.getName(),
                "checkSecurity", "()V");
    }
}
