package com.niotest.netty.serializ;

import java.io.Serializable;

/**
 * Created by neoyin on 14/11/18.
 */
public class SubscribeReq implements Serializable {
    private static final long serialVersionUID = 7002180413428047515L;

    private int subReqId;

    private String username;

    private String productname;

    private String phonenumber;

    private String address;

    public int getSubReqId() {
        return subReqId;
    }

    public void setSubReqId(int subReqId) {
        this.subReqId = subReqId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubscribeReq{" +
                "subReqId=" + subReqId +
                ", username='" + username + '\'' +
                ", productname='" + productname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public SubscribeReq(int subReqId, String username, String productname, String phonenumber, String address) {
        this.subReqId = subReqId;
        this.username = username;
        this.productname = productname;
        this.phonenumber = phonenumber;
        this.address = address;
    }
}
