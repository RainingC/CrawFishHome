package org.lanqiao.entity;

import java.util.Date;

public class Course {
    private int course_id;
    private String course_name;
    private String company;
    private int price;
    private String cover;
    private String synopsis;
    private Date putway_time;
    private int grade;
    private int kind_id;
    private int page_view;
    public Course(){

    }

    public Course(String course_name){
        this.course_name = course_name;
    }

    public Course(int course_id, String course_name, String company, int price, String cover, String synopsis, int kind_id, Date putway_time, int grade) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.company = company;
        this.price = price;
        this.cover = cover;
        this.synopsis = synopsis;
        this.kind_id = kind_id;
        this.putway_time = putway_time;
        this.grade = grade;
    }


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getPutway_time() {
        return putway_time;
    }

    public void setPutway_time(Date putway_time) {
        this.putway_time = putway_time;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
