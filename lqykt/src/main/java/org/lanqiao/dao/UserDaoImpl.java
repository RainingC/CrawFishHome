package org.lanqiao.dao;



import org.lanqiao.entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

    public List<User> checkUsers(User user) {
        return executeQuery("select * from user where user_phone=? and user_pwd=?", new Object[]{user.getUser_phone(), user.getUser_pwd()});
    }
    public int addUser(User user) {
        return executeUpdate("insert into user(user_phone,user_pwd,user_name,user_picaddress) values(?,?,?,'images/small.jpg')", new Object[]{user.getUser_phone(), user.getUser_pwd(),"lanqiao"+user.getUser_phone()});
    }
    public List<User> select(User user)
    {
        return executeQuery("select * from user where user_phone=?",new Object[]{user.getUser_phone()});
    }

    @Override
    public int updateUser(User u) {
        return executeUpdate("update user set user_name =? ,user_qq=?,user_sex =? ,user_signature=? where user_id=?",
                new Object[]{u.getUser_name(),u.getUser_qq(),u.getUser_sex(),u.getUser_signature(),u.getUser_id()});

    }

    @Override
    public List<User> selectUser(User u) {
        return  executeQuery("select user_name from user where user_id =?",
                new Object[]{u.getUser_id()});
    }

    @Override
    public List<User> showUserInfo(User user){
        List<User> userList = executeQuery("select * from user where user_id = ?",new Object[]{user.getUser_id()});
        return userList;
    }

}
