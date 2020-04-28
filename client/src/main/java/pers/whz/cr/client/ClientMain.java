package pers.whz.cr.client;

import java.io.IOException;
import java.net.Socket;

/**
 * 客服端运行入口方法
 *
 * @author hongzhou.wei
 * @date 2020/4/28
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            int port = 6666;
            String host = "127.0.0.1";
            final Socket socket = new Socket(host, port);
            //往服务器发送数据
            new Thread(new WriteDataToServerRunnable(socket)).start();
            //从服务器读数据
            new Thread(new ReadDataFromServerRunnable(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
