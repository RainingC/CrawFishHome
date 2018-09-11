package org.lanqiao.dao;

import org.lanqiao.entity.Comments;

import java.util.List;

public class CommentsDaoImpl extends BaseDao<Comments> implements CommentsDao{
    //插入
    @Override
    public int insert(Comments comments) {
        return executeUpdate("insert into comments(course_id,content,user_name) values(?,?,?)",
        new Object[]{comments.getCourse_id(),comments.getContent(),comments.getUser_name()});
    }
    //删除
    @Override
    public int delete(int id) {
        return executeUpdate("delete course where course_id = ?", new Object[]{id});
    }
    //修改
    @Override
    public void update(String sql, Object[] obj) {
        executeUpdate(sql, obj);
    }
    //查询
    @Override
    public int select(int id) {   // key是查询的关键字
         List list =executeQuery("select * from comments where course_id = ? order by comments_id desc",
                new Object[]{id});
        return list.size();
    }
    @Override
    public List<Comments> select(int id,int pageNum,int pageSize) {   // key是查询的关键字
        return executeQuery("select * from comments where course_id = ? order by comments_id desc limit ?,?",
                new Object[]{id,(pageNum-1)*pageSize,pageSize});
    }

//    @Override
//    public int getMsgCount(){
//        return getRecordCount("select count(*) from comments");
//    }


}
