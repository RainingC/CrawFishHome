package org.lanqiao.entity;

public class Admin {
    private String user_phone;
    private String user_pwd;
    public Admin()
    {

    }
    public Admin(String user_phone,String user_pwd)
    {
        this.user_phone=user_phone;
        this.user_pwd=user_pwd;
    }
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}
