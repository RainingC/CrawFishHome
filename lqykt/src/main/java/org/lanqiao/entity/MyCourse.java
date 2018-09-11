package org.lanqiao.entity;
import java.io.Serializable;

public class MyCourse implements Serializable {
    private  int mycouse_id;
    private  int user_id;
    private  int aleardy_look;
    private int last_time;
    private String course_name;

    public MyCourse(int mycouse_id, int user_id, int aleardy_look, int last_time, String course_name) {
        this.mycouse_id = mycouse_id;
        this.user_id = user_id;
        this.aleardy_look = aleardy_look;
        this.last_time = last_time;
        this.course_name=course_name;
    }

    public int getMycouse_id() {
        return mycouse_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAleardy_look() {
        return aleardy_look;
    }

    public int getLast_time() {
        return last_time;
    }
    public String getCourse_name(){
        return course_name;
    }
}
