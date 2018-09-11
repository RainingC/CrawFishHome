package org.lanqiao.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private int id;
    private String username;
    private String msg;
    private Date createTime;
    public User() {

    }
    public User(String username,String msg)
    {
        this.username=username;
        this.msg=msg;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    }
