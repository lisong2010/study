import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-08
 */
public class IoFileCopy {

    public void copyFileByStream(File path, File dest) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(path);
            fos = new FileOutputStream(dest);

            byte[] b = new byte[1024];
            int length;

            while((length = fis.read(b) )!= -1) {
                fos.write(b, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
