package com.jiakun.fresh.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 * 功能:UDP客户端,在UDP中没有Socket和ServerSocket来区分一个是客户端一个是服务器端，
 * 相反在UDP中客户端和服务器端都是基于相同的DatagramSocket来进行传输的.
 * 利用UDP进行网络通信主要涉及两个类，一个是DatagramPacket,主要用来将数据字节填充到UDP数据报中，用来解包接受数据的，
 * 用来收和发UDP数据报。一个是DatagramSocket主要用来是建立客户端和服务器端，用来接受和发送数据报数据的。
 * Created by liujiakun on 16-8-14.
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        int serverPort = 3000;
        String serverAddressStr = "127.0.0.1";

        String sendStr = "你好,UDP服务器!";
        byte[] buf = new byte[1024];
        // 客户端在9000端口监听接收到的数据
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress servAddress = InetAddress.getByName(serverAddressStr);
        // 使用流的方法进行读写,避免传输中文产生乱码
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(ostream);
        outputStream.writeUTF(sendStr);
        outputStream.close();
        byte[] data = ostream.toByteArray();
        // 定义用来发送数据的DatagramPacket实例
        DatagramPacket datagramPacketSend = new DatagramPacket(data, data.length, servAddress, serverPort);
        DatagramPacket datagramPacketRecv = new DatagramPacket(buf, 1024);
        // 数据发向服务器端
        datagramSocket.setSoTimeout(5000);
        boolean isFinished = false;
        while (!isFinished) {
            datagramSocket.send(datagramPacketSend);
            try {
                datagramSocket.receive(datagramPacketRecv);
                // 如果接收到的数据不是来自目标地址,则抛出异常
                if (!datagramPacketRecv.getAddress().equals(servAddress)) {
                    throw new IOException("Received packet from an umknown source");
                }
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(
                        datagramPacketRecv.getData(), datagramPacketRecv.getOffset(), datagramPacketRecv.getLength()));
                String recvStr = dataInputStream.readUTF();
                System.out.println("收到服务器端消息:" + recvStr);
            } catch (SocketTimeoutException e) {
                System.out.println("接收数据超时!");
            } finally {
                isFinished = true;
            }
        }
    }

}