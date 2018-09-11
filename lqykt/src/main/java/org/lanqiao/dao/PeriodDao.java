package org.lanqiao.dao;

import org.lanqiao.entity.Period;

import java.util.List;

public interface PeriodDao {
    public int AddPeriod(int cid,int pid,String pname,String address);
    //删除
    public int delete(Period p);
    //查询
    public List<Period> select(Period p) ;

    //查询课时
    public List<Period> select(int id) ;
    //查询视频地址
    public  List<Period> selectId(int id);
}
