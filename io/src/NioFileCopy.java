import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-08
 */
public class NioFileCopy {
    public static void copyFileByChannel(File path, File dest) throws Exception {
        FileChannel fileChannel = new FileInputStream(path).getChannel();
        FileChannel destChannel = new FileInputStream(dest).getChannel();

        for(long count = fileChannel.size(); count >0;) {
            long transferd = fileChannel.transferTo(fileChannel.position(), count, destChannel);

            fileChannel.position(destChannel.position() + transferd);
            count -= transferd;
        }
    }
}
