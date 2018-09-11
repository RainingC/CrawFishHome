package org.lanqiao.dao;


import org.lanqiao.entity.Admin;

import java.util.List;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {
    public List<Admin> checkAdmin(Admin admin)
    {
        return executeQuery("select user_phone,user_pwd from user where user_phone=? and user_pwd=?",new Object[]{admin.getUser_phone(),admin.getUser_pwd()});
    }
}
