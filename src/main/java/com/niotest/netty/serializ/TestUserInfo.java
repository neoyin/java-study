package com.niotest.netty.serializ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by neoyin on 14/11/18.
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo("neoyin",001);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("serializable lenght "+b.length);
        bos.close();
        System.out.println("--------------");
        System.out.println("--"+info.codeC().length);

    }
}
