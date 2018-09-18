package asm;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-09-06
 */
public class Generator {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassReader cr = new ClassReader(Class.forName(Account.class.getName()).getResourceAsStream("Account.class"));
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();
        File file = new File("/Users/rimatsu/Github/study/spike/target/classes/asm/Account.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();

        Account.class.newInstance().operation();
    }
}
