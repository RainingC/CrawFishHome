package org.lanqiao.dao;

import org.lanqiao.entity.News;

import java.util.List;

public class NewsDaoImpl extends BaseDao<News> implements NewsDao{
    @Override
    public int ShowNewsNum(int i) {
        return getRecordCount("select count(*) from news where user_id = "+i+" and news_status = 0");
    }

    @Override
    public List<News> ShowNewsInfo(int i1,int pageNum,int pageSize) {
        return executeQuery("select * from news where user_id = ? order by news_time desc limit ?,?",new Object[]{i1,(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public int UpdateStatus(int i2) {
        return executeUpdate("update news set news_status = 1 where news_id = ?",new Object[]{i2});
    }

    @Override
    public int GetNewsCount(int i3) {
        return getRecordCount("select count(*) from news where user_id ="+i3);
    }

    @Override
    public int AddNews(int userid,int course_id,String newsinfo) {
        return executeUpdate("insert into news(user_id,course_id,news_info) values(?,?,?)",new Object[]{userid,course_id,newsinfo});
    }

    @Override
    public List<News> ShowNewsdialog(int uid) {
        return executeQuery("select * from news where user_id = ? and floor((NOW()-news_time)/60)<5",new Object[]{uid});
    }

}
