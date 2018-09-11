package org.lanqiao.entity;

public class Period {
    private int period_id;
    private String period_name;
    private String video_address;
//    private int duration;
    private int course_id;
    private int id;
    public Period(){

    }

    public Period(int period_id, String preiod_name, String video_address, int course_id) {
        this.period_id = period_id;
        this.period_name = preiod_name;
        this.video_address = video_address;
//        this.duration = duration;
        this.course_id = course_id;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getVideo_address() {
        return video_address;
    }

    public void setVideo_address(String video_address) {
        this.video_address = video_address;
    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
