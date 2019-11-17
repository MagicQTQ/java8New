package file.netmodel.tcp.uploadfile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author qtq
 * @Created on 2019-11-17 15:45.
 */
public class MultiUploadServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器Socket对象
        ServerSocket ss = new ServerSocket(11111);

        while (true) {
            Socket s = ss.accept();
            new Thread(new MultiUserFile(s)).start();  // 如果上传，服务器起一个线程给客户端连接
        }
    }
}
