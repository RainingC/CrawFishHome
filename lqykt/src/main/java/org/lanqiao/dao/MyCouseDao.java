package org.lanqiao.dao;

import org.lanqiao.entity.MyCourse;

import java.util.List;

public interface MyCouseDao {
    int addCourse(MyCourse myCourse);
    List<MyCourse> selectCourse(MyCourse myCouse);
}
