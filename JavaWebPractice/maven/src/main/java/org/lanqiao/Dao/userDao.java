package org.lanqiao.Dao;

import org.lanqiao.entity.User;

import java.util.List;

public class userDao extends BaseDao<User>{
   public int addUser(User user)
   {
       return executeUpdate("insert into message(username,msg) values(?,?)",new Object[]{user.getUsername(),user.getMsg()});
   }
   public List<User> showAllUser(int pageNum,int pageSize)
   {
       return executeQuery("select id,username,msg,createTime from message limit ?,?",new Object[]{(pageNum-1)*pageSize,pageSize});
   }
   public int getMsgCount(){
       return getRecordCount("select count(*) from message");
   }
}