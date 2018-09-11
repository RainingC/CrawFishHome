package org.lanqiao.dao;

import org.lanqiao.entity.Comments;

import java.util.List;

public interface CommentsDao {
    //插入
    public int insert(Comments comments);
    //删除
    public int delete(int id);
    //修改
    public void update(String sql, Object[] obj);
    //查询
//    public List<Comments> select(int id) ;
    //分页
    public List<Comments> select(int id, int pageNum, int pageSize) ;
    public int select(int id);

//    public int getMsgCount();
}
