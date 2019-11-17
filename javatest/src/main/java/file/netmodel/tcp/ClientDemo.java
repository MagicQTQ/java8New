package file.netmodel.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP协议发送数据：
 * A:创建发送端的Socket对象
 * 		这一步如果成功，就说明连接已经建立成功了。
 * B:获取输出流，写数据
 * C:释放资源
 *
 * 连接被拒绝。TCP协议一定要先看服务器。
 * java.net.ConnectException: Connection refused: connect
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端的Socket对象
        // Socket(InetAddress address, int port)
        // Socket(String host, int port)
        // Socket s = new Socket(InetAddress.getByName("192.168.12.92"), 8888);
        Socket s = new Socket("192.168.100.100", 8888);

        // 获取输出流，写数据
        // public OutputStream getOutputStream()
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());


        //又读取服务端的响应回来的信息
        InputStream in = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = in.read(bys); //阻塞式方法
        String response = new String(bys, 0, len);
        System.out.println("client:" + response);

        // 释放资源
        s.close();
    }
}