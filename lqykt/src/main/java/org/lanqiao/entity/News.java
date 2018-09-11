package org.lanqiao.entity;

import java.util.Date;

public class News {
    private int news_id;
    private int user_id;
    private int course_id;
    private String news_info;
    private Date news_time;
    private int news_status;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
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

    public String getNews_info() {
        return news_info;
    }

    public void setNews_info(String news_info) {
        this.news_info = news_info;
    }

    public Date getNews_time() {
        return news_time;
    }

    public void setNews_time(Date news_time) {
        this.news_time = news_time;
    }

    public int getNews_status() {
        return news_status;
    }

    public void setNews_status(int news_status) {
        this.news_status = news_status;
    }
}
