package com.jiakun.fresh;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;

/**
 * 处理TCP粘包和拆包
 *
 * @author jiakun.liu
 * @create 2017-11-19 下午9:51
 **/

public class TimeServer1 {

    public void bind(int port) throws InterruptedException {
        //配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler1());
            //绑定端口,同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务端监控端口关闭
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler1 extends ChannelInitializer<SocketChannel>{
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            //以此遍历ByteBuf中的可读字节,判断看是否有"\n"或者"\r\n",如果有,就以此位置为结束位置,从可读索引到结束位置 区间的字节就
            // 组成了一行.它是以换行符为结束标志的解码器
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));//1024表示单条消息的最大长度
            //将接收到的对象转换成字符串
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler1());
        }
    }


    private class TimeServerHandler1 extends ChannelHandlerAdapter{
        private int counter=0;
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body=(String)msg;
            System.out.println("server receive order:"+body+";counter:"+ ++this.counter);
            String currentTime=new Date(System.currentTimeMillis()).toString()+System.getProperty("line.separator");
            ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
            ctx.writeAndFlush(resp);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port=8082;
        new TimeServer1().bind(port);

    }
}
