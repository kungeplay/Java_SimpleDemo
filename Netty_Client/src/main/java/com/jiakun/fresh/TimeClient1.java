package com.jiakun.fresh;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 支持TCP粘包
 *
 * @author jiakun.liu
 * @create 2017-11-19 下午10:05
 **/

public class TimeClient1 {

    public void connect(int port,String host)throws Exception{
        //配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {

            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new TimeClientHandler1());
                        }
                    });
            //发起异步连接操作
            ChannelFuture f=b.connect(host,port).sync();
            //等待客户端链路关闭
            f.channel().closeFuture().sync();
        }finally {
            //优雅退出，释放NIO线程
            group.shutdownGracefully();
        }
    }
    //业务handler
    private class TimeClientHandler1 extends ChannelHandlerAdapter {
        private byte[] req;
        private int counter;

        public TimeClientHandler1() {
            req=("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            ByteBuf message=null;
            for (int i=0;i<100;i++){
                message = Unpooled.buffer(req.length);
                message.writeBytes(req);
                ctx.writeAndFlush(message);//写还需要转成ByteBuf
            }
        }
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String body=(String) msg;
            System.out.println("Now:"+body+";counter:"+ ++counter);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            //释放资源
            System.out.println("Unexpected exception from downstream:"+cause.getMessage());
            ctx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        int port=8082;
        new TimeClient1().connect(port,"127.0.0.1");
    }
}
