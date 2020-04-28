package pers.whz.cr.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端运行入口方法
 *
 * @author hongzhou.wei
 * @date 2020/4/28
 */
public class ServerMain {
    public static void main(String[] args) {
        final int port = 6666;
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("等待客户端连接中...");
            while (true) {
                // 监听客户端
                Socket client = serverSocket.accept();
                // 执行任务
                executorService.execute(new ServerRunnable(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
