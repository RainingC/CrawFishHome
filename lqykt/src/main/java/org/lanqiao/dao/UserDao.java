package org.lanqiao.dao;


import org.lanqiao.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> checkUsers(User user);
    public int addUser(User user);
    public List<User> select(User user);
    public int updateUser(User u);
    public List<User> selectUser(User u);
    public List<User> showUserInfo(User user);
}
