package org.lanqiao.dao;


import org.lanqiao.entity.User;

import java.util.List;

public class DelectDaoImpl extends BaseDao<User> implements DelectDao {
    public List<User> selectAll( )
    {
        return executeQuery("select * from user");
    }
    public int delectuser(User u)
    {
        return executeUpdate("DELETE FROM user WHERE user_id=?",new Object[]{u.getUser_id()});
     }
}
