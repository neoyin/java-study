package com.niotest.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by neoyin on 14/11/17.
 */
public class AsyncTimeServerHandler implements Runnable{

    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asyncChannel;


    public AsyncTimeServerHandler(int port) {
        this.port = port;

        try {
            asyncChannel = AsynchronousServerSocketChannel.open();
            asyncChannel.bind(new InetSocketAddress(port));
            System.out.println("AsyncTimeServerHandler.AsyncTimeServerHandler is start in port "+port);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
//        doAccept();
        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    private void doAccept() {
//        asyncChannel.accept(this,new AcceptCompletionHandler());
//    }
}
