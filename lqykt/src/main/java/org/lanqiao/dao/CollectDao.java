package org.lanqiao.dao;

import org.lanqiao.entity.Collect;
import org.lanqiao.entity.User;

import java.util.List;


public interface CollectDao {


    public int insertCollectInfo(Collect collect);


    public List<Collect> showMyCollect(Collect collect);

    public  Collect  findMyCourseName(User u);
}
