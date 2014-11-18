package com.niotest.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Created by neoyin on 14/11/18.
 */
public class TimeServerDecoderHandler extends ChannelHandlerAdapter {

    private static int counter ;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String) msg;
        System.out.println("The server receive order "+body+" the count is "+ ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"bad order";

        ByteBuf buf = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(buf);
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
