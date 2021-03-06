package com.niotest.netty.serializ;

import io.netty.buffer.ByteBuf;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * Created by neoyin on 14/11/18.
 */
public class UserInfo implements Serializable{
    private static final long serialVersionUID = -2814366907208825817L;

    private String username;

    private int userId;

    public UserInfo(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte[] codeC(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] value = this.username.getBytes();
        byteBuffer.putInt(value.length);
        byteBuffer.put(value);
        byteBuffer.putInt(this.userId);
        byteBuffer.flip();
        value = null;
        byte[] res = new byte[byteBuffer.remaining()];
        byteBuffer.get(res);
        return res;


    }

}
