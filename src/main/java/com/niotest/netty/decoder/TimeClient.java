package com.niotest.netty.decoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.nio.channels.SocketChannel;

/**
 * Created by neoyin on 14/11/18.
 */
public class TimeClient {

    public void connect(int port, String host) {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {


            @Override
            protected void initChannel(io.netty.channel.socket.SocketChannel ch) throws Exception {

                ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(new TimeClientDecoderHandler());
            }
        });
        try {

            //发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            //等待客户端链接关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }


    }

    public static void main(String[] args) {
        int port =8080;
        new TimeClient().connect(8080,"127.0.0.1");

    }

}
