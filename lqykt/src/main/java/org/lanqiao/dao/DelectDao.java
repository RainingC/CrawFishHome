package org.lanqiao.dao;


import org.lanqiao.entity.User;

import java.util.List;

public interface DelectDao {
    public List<User> selectAll();
    public int delectuser(User u);
}
