package org.lanqiao.dao;


import org.lanqiao.entity.CourseKind;

import java.util.List;

public interface CourseKindDao {
    public List<CourseKind> GetKindName(int i);
    public List<CourseKind> CheckCourseId(String kindname);
    //查询
    public List<CourseKind> select(CourseKind ck) ;
}
