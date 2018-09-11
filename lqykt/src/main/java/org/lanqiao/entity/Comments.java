package org.lanqiao.entity;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {
    private int comments_id;//评论ID
    private int course_id;//课程ID
    private int user_id;//用户ID
    private String content;//评论内容
    private Date content_time;//评论时间
    private int reuser_id;//被回复者ID
    private  String user_name;//用户名字
    public Comments(){

    }

    public Comments(int comments_id, int course_id, int user_id, String content, Date content_time, int reuser_id) {
        this.comments_id = comments_id;
        this.course_id = course_id;
        this.user_id = user_id;
        this.content = content;
        this.content_time = content_time;
        this.reuser_id = reuser_id;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getComments_id() {
        return comments_id;
    }

    public void setComments_id(int comments_id) {
        this.comments_id = comments_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getContent_time() {
        return content_time;
    }

    public void setContent_time(Date content_time) {
        this.content_time = content_time;
    }

    public int getReuser_id() {
        return reuser_id;
    }

    public void setReuser_id(int reuser_id) {
        this.reuser_id = reuser_id;
    }
}
