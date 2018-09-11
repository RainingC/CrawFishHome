package org.lanqiao.dao;

import org.lanqiao.entity.*;

import java.util.List;

public interface CourseDao{
    public List<Course> ShowBestCourse();
    public List<Course> ShowFreeCourse();
    public List<Course> ShowNewCourse();
    public List<Course> ShowPrompt(String str);
    public List<Course> ReturnCourseId();
    public List<Course> showCourseInfoDemo(Course course);
    public List<Course> showCourseInfo(Cart cart);
    public List<Course> showCourseInfo(Order order);
    public int AddCourse(String cname,String comp,int price,int kindid,String synopsis,String cover);
    //删除
    public int delete(Course c);
    //查询二级标题课程
    public List<Course> select(CourseKind ck) ;
    //查询一级标题课程
    public List<Course> selectAll(CourseKind ck) ;
    // 查询三级标题课程
    public List<Course> selectSignle(CourseKind ck, int pageBegin, int pageSize) ;

    //删除
    public int delete(int id);
    public List<Course> selectid(Course c);

    public List<Course> selectCourse(Collect collect);
    public List<Course> showCourseName(User user) ;
}
