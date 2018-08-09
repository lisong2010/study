import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-08
 */
public class NioServer extends Thread{

    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while(it.hasNext()) {
                    SelectionKey selectionKey = it.next();
                    sayHello((ServerSocketChannel) selectionKey.channel());
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sayHello(ServerSocketChannel channel) {
        try (SocketChannel client = channel.accept();) {
            client.write(Charset.defaultCharset().encode("Hello world"));
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        NioServer nioServer = new NioServer();
        nioServer.start();
        Thread.sleep(200);

        try (Socket client = new Socket(InetAddress.getLocalHost(), 8888)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            br.lines().forEach(v -> System.out.println(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
