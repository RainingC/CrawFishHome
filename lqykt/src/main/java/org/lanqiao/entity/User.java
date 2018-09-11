package org.lanqiao.entity;

public class User {
    private int user_id;
    private  String user_phone;
    private  String user_pwd;
    private  String user_name;
    private  String user_sex;
    private  String user_picaddress;
    private  String user_signature;
    private  int user_qq;
    public User()
    {

    }
    public User(int user_id)
    {
        this.user_id=user_id;
    }
    public User(String user_phone,String user_pwd)
    {
        this.user_phone=user_phone;
        this.user_pwd=user_pwd;
    }
    public User(int user_id,String user_phone,String user_pwd,String user_name)
    {
        this.user_id=user_id;
        this.user_phone=user_phone;
        this.user_pwd=user_pwd;
        this.user_name=user_name;
    }

    public User(int user_id, String user_name, int user_qq, String user_sex, String user_picaddress, String user_signature) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_qq = user_qq;
        this.user_sex = user_sex;
        this.user_picaddress = user_picaddress;
        this.user_signature = user_signature;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_picaddress() {
        return user_picaddress;
    }

    public void setUser_picaddress(String user_picaddress) {
        this.user_picaddress = user_picaddress;
    }

    public String getUser_signature() {
        return user_signature;
    }

    public void setUser_signature(String user_signature) {
        this.user_signature = user_signature;
    }

    public int getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(int user_qq) {
        this.user_qq = user_qq;
    }
}
