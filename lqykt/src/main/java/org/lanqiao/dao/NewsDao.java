package org.lanqiao.dao;

import org.lanqiao.entity.News;

import java.util.List;

public interface NewsDao {
    public int ShowNewsNum(int i);
    public List<News> ShowNewsInfo(int i1,int pageNum,int pageSize);
    public int UpdateStatus(int i2);
    public int GetNewsCount(int i3);
    public int AddNews(int userid,int courseid,String newsinfo);
    public List<News> ShowNewsdialog(int uid);
}
