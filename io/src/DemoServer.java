import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lisong(OF2016) company qianmi.com Date    2018-08-08
 */
public class DemoServer extends Thread {

    private ServerSocket serverSocket;

    public DemoServer() {
        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(8);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
//                requestHandler.start();
                executor.submit(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DemoServer demoServer = new DemoServer();
        demoServer.start();

        try (Socket client = new Socket(InetAddress.getLocalHost(), demoServer.getPort())) {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            br.lines().forEach(v -> System.out.println(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RequestHandler extends Thread {

    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
            printWriter.println("hello world");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
