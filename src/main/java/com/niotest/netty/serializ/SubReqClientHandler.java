package com.niotest.netty.serializ;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by neoyin on 14/11/18.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 100; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private Object subReq(int i) {

        SubscribeReq req = new SubscribeReq(i,"neoyin","ntest"+i,"12345","bj");


        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
