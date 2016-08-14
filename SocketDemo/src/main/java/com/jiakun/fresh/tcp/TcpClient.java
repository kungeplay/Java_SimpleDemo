package com.jiakun.fresh.tcp;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 功能:连接服务器后发送并接收消息
 * Created by liujiakun on 16-8-14.
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8899;
        Socket client = new Socket(host, port);
        Writer writer = new OutputStreamWriter(client.getOutputStream(), "utf-8");
        writer.write("你好,服务器");
        writer.write("eof\n");
        writer.flush();
        // 写完以后进行读操作
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
        // 设置超时时间为10秒
        client.setSoTimeout(10 * 1000);
        StringBuffer sb = new StringBuffer();
        String temp;
        int index;
        try {
            while ((temp = br.readLine()) != null) {
                if ((index = temp.indexOf("eof")) != -1) {//eof作为消息结束标记
                    sb.append((temp.substring(0, index)));
                    break;
                }
                sb.append(temp);
            }
        }
        catch (SocketTimeoutException e){
            System.out.println("数据读取超时");
        }
        System.out.println("收到服务器端消息:"+sb);
        writer.close();
        br.close();
        client.close();
    }

}
