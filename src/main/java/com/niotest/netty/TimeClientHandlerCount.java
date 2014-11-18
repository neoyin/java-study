package com.niotest.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by neoyin on 14/11/17.
 */
public class TimeClientHandlerCount extends ChannelHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TimeClientHandlerCount.class);

    private byte[] req;
    private int counter;
    public TimeClientHandlerCount() {
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf firstMessage = null;

        for (int i = 0; i < 100; i++) {
            firstMessage = Unpooled.buffer(req.length);
            firstMessage.writeBytes(req);

            ctx.writeAndFlush(firstMessage);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req);
        System.out.println("now is :"+body+"---- counter"+ ++counter);



    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Unexpected exception from downstream"+cause.getMessage());
        ctx.close();
    }
}
