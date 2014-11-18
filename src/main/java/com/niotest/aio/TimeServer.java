package com.niotest.aio;

/**
 * Created by neoyin on 14/11/17.
 */
public class TimeServer {

    public static void main(String[] args) {
        int port =8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-asynctime server").start();
    }

}

