package com.jiakun.fresh.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能:接收客户端的消息并发送消息
 * Created by liujiakun on 16-8-14.
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        int port = 8899;

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            // server尝试接收其他socket的连接请求,server的accept方法是阻塞的
            Socket socket = serverSocket.accept();
            //每接收一个socket就建立一个新的线程来处理它.
            new Thread(new Task(socket)).start();

        }
    }

    static class Task implements Runnable {
        private Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                handleSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void handleSocket() throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            StringBuilder sb = new StringBuilder();
            String temp;
            int index;
            //BufferedReader.readLine()方法是一次读一行,此方法是阻塞的,直到它读了一行数据为止,也即直到程序遇到换行符或者对应的流结束符
            // readLine方法才会认为读到一行.才会结束其阻塞
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(temp);
                if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收
                    sb.append(temp.substring(0,index));
                    break;
                }
                sb.append(temp);
            }
            System.out.println("收到客户端消息:" + sb);
            //读完之后写一句
            Writer writer = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
            writer.write("你好,客户端!");
            writer.write("eof\n");//每次发送消息一定要写入换行符(流结束之后会自动标记为结束,readLine方法可以识别.)
            //写完之后要flush.
            writer.flush();
            writer.close();
            bufferedReader.close();
            socket.close();
        }
    }

}

