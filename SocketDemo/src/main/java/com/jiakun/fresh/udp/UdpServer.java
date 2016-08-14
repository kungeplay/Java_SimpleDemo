package com.jiakun.fresh.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 功能:UDP客户端,在UDP中没有Socket和ServerSocket来区分一个是客户端一个是服务器端，
 * 相反在UDP中客户端和服务器端都是基于相同的DatagramSocket来进行传输的.
 * 利用UDP进行网络通信主要涉及两个类，一个是DatagramPacket,主要用来将数据字节填充到UDP数据报中，用来解包接受数据的，
 * 用来收和发UDP数据报。一个是DatagramSocket主要用来是建立客户端和服务器端，用来接受和发送数据报数据的。
 * Created by liujiakun on 16-8-14.
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        String sendStr = "你好,UDP客户端!";
        int port = 3000;
        // 服务器端在3000端口处监听接收到的数据
        DatagramSocket datagramSocket = new DatagramSocket(port);
        byte[] buf = new byte[1024];

        // 接收从客户端发送过来的数据
        DatagramPacket datagramPacketRec = new DatagramPacket(buf, 1024);
        System.out.println("server is on ,wating for client to send data....");
        boolean isFinished = false;
        while (!isFinished) {
            // 服务器端接收来自客户端的数据
            datagramSocket.receive(datagramPacketRec);
            System.out.println("server received data from client:");
            // 使用流的方式,防止产生乱码
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(datagramPacketRec.getData(),
                    datagramPacketRec.getOffset(), datagramPacketRec.getLength()));
            String receiveStr = dataInputStream.readUTF();
            if (receiveStr.indexOf("stop") != -1) {
                isFinished = true;
            }
            String recvAddressStr = datagramPacketRec.getAddress().getHostAddress() + ":" + datagramPacketRec.getPort();
            System.out.println("接收到客户端:" + recvAddressStr + ",udp消息:" + receiveStr);

            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            DataOutputStream outputStream = new DataOutputStream(ostream);
            outputStream.writeUTF(sendStr);
            outputStream.close();
            byte[] data = ostream.toByteArray();

            DatagramPacket datagramPacketSend = new DatagramPacket(data, data.length);
            datagramPacketSend.setAddress(datagramPacketRec.getAddress());
            datagramPacketSend.setPort(datagramPacketRec.getPort());
            datagramSocket.send(datagramPacketSend);
            // 由于DatagramSocket类在接收了数据之后,其内部消息长度值会变为实际接收的消息的字节数,所以这里要将datagramPacketRec内部消息长度重新置为1024
            datagramPacketRec.setLength(1024);
        }
        datagramSocket.close();
    }

}
