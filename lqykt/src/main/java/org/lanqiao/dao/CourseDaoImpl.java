package org.lanqiao.dao;

import org.lanqiao.entity.*;

import java.util.List;

public class CourseDaoImpl extends BaseDao<Course> implements  CourseDao{

    @Override
    public List<Course> ShowBestCourse() {
        return executeQuery("select course_id,course_name,company,page_view,cover from course order by page_view desc");
    }

    @Override
    public List<Course> ShowFreeCourse() {
        return executeQuery("select course_id,course_name,company,page_view,cover from course where price = 0 order by page_view desc");
    }

    @Override
    public List<Course> ShowNewCourse() {
        return executeQuery("select course_id,course_name,company,page_view,cover from course order by putway_time desc");
    }

    @Override
    public List<Course> ShowPrompt(String val) {
        return executeQuery("select * from course where course_name like '%"+val+"%' order by page_view desc");
    }

    @Override
    public List<Course> ReturnCourseId() {
        return executeQuery("select * from course order by putway_time desc");
    }

    @Override
    public int AddCourse(String cname, String comp, int price, int kindid,String synopsis,String cover) {
        return executeUpdate("insert into course(course_name,company,price,kind_id,synopsis,cover) VALUES(?,?,?,?,?,?)",new Object[]{cname,comp,price,kindid,synopsis,cover});
    }

    @Override
    public List<Course> showCourseInfoDemo(Course course){
        List<Course> coursesList = executeQuery("select course_name,company,price,cover from course where course_id = ?",new Object[]{course.getCourse_id()});
        return coursesList;
    }
    public List<Course> showCourseInfo(Cart cart) {
        List<Course> courseList = executeQuery("SELECT * from course where course_id in (select course_id from cart where user_id = ?)", new Object[]{cart.getUser_id()});
        return  courseList;
    }
    public List<Course> showCourseInfo(Order order){
        List<Course> courseList = executeQuery("SELECT * from course where course_id = ?", new Object[]{order.getCourse_id()});
        return  courseList;
    }

    //删除
    public int delete(Course c) {
        return executeUpdate("delete from course where course_id = ?", new Object[]{c.getCourse_id()});
    }
    //根据二级目录查询课程信息
    public List<Course> select(CourseKind ck) {
        return executeQuery("select *\n" +
                        "    from course c, (select kind_id from coursekind\n" +
                        "    where pid = (select kind_id from coursekind where kind_name = ?)) cc\n" +
                        "    where c.kind_id = cc.kind_id",
                new Object[]{ck.getKind_name()});
    }

    // 根据一级目录 查询课程信息
    @Override
    public List<Course> selectAll(CourseKind ck) {
        return executeQuery(" select * from course c\n" +
                        "    where c.kind_id in (select kind_id from coursekind c1\n" +
                        "    where c1.pid in (select kind_id from coursekind\n" +
                        "    where pid = (select kind_id from coursekind where kind_name = ?)))",
                new Object[]{ck.getKind_name()});
    }

    // 三级目录
    @Override
    public List<Course> selectSignle(CourseKind ck, int pageBegin, int pageSize) {
        return executeQuery("select * from course\n" +
                        "    where kind_id = (select kind_id from coursekind where kind_name = ?)\n" +
                        "    limit ?,?",
                new Object[]{ck.getKind_name(), pageBegin, pageSize});
    }

    //删除
    public int delete(int id) {
        return executeUpdate("delete course where course_id = ?", new Object[]{id});
    }
    //查询
    @Override
    public List<Course> selectid(Course course) {
        List<Course> courseList = executeQuery("select * from course where course_id = ?", new Object[]{course.getCourse_id()});
        return courseList;
    }

    @Override
    public List<Course> selectCourse(Collect collect){
        return executeQuery("select * from course where course_id in(select course_id from collect where user_id =?) ",
                new Object[]{collect.getUser_id()});
    }
    @Override
    public List<Course> showCourseName(User user) {
        return executeQuery("select course_name , cover from course where course_id in" +
                " (select course_id from `order` where user_id=?)", new Object[]{user.getUser_id()});
    }


}
