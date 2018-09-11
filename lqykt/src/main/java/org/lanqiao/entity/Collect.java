package org.lanqiao.entity;

import java.io.Serializable;

public class Collect  implements Serializable {
    private int user_id;
    private int course_id;
    private int collect_id;
    private String course_name;
    public Collect(){

    }

    public Collect(int user_id, int course_id, int collect_id, String course_name) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.collect_id = collect_id;
        this.course_name = course_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
