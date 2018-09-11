package org.lanqiao.dao;

import org.lanqiao.entity.MyCourse;

import java.util.List;

public class MyCourseImpl extends BaseDao<MyCourse> implements MyCouseDao {
    @Override
    public int addCourse(MyCourse couse){
        return executeUpdate("insert into course(course_name) values (?)",
                new Object[]{couse.getCourse_name()});


    }
    @Override
    public List<MyCourse> selectCourse(MyCourse myCouse) {
        return executeQuery("select user_id,course_id,course_name from course limit ?,?,?",
                new Object[]{myCouse.getUser_id(),myCouse.getMycouse_id(),myCouse.getCourse_name()});
    }
}
