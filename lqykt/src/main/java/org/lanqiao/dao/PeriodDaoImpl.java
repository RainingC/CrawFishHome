package org.lanqiao.dao;

import org.lanqiao.entity.Period;

import java.util.List;

public class PeriodDaoImpl extends BaseDao<Period> implements PeriodDao{
    @Override
    public int AddPeriod(int cid,int pid,String pname,String address) {
        return executeUpdate("insert into period(course_id,period_id,period_name,video_address) values(?,?,?,?);",new Object[]{cid,pid,pname,address});
    }

    @Override
    public int delete(Period p) {
        return executeUpdate("delete from period where id = ?", new Object[]{p.getId()});
    }

    @Override
    public List<Period> select(Period p) {
        return executeQuery("select id, period_name, video_address, course_id from period where course_id = ?",
                new Object[]{p.getCourse_id()});
    }

    @Override
    public List<Period> select(int id) {
        return executeQuery("select * from period where course_id = ?",new Object[]{id});
    }
    @Override
    public List<Period> selectId(int id){
        return executeQuery("select video_address from period wher id = ?" ,new Object[]{id});
    }
}
