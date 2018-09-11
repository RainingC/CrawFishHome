package org.lanqiao.dao;


import org.lanqiao.entity.Collect;
import org.lanqiao.entity.User;

import java.util.List;

public class CollectImpl extends BaseDao<Collect> implements CollectDao {
    public int insertCollectInfo(Collect collect){
        return executeUpdate("insert into collect(user_id,course_id)values(?,?)",new Object[]{collect.getUser_id(),collect.getCourse_id()});
    }

    @Override
    public List<Collect> showMyCollect(Collect c) {
        List<Collect> collectList = executeQuery("select * from collect where user_id=?",new Object[]{c.getUser_id()});
        if(collectList.size()>0){
            return collectList;
        }
        return null;
    }

    @Override
    public Collect findMyCourseName(User u) {
        return null;
    }


}
