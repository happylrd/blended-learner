package io.happylrd.childishscorems.model;


import com.google.gson.annotations.SerializedName;

/**
 * url: http://localhost:8000/activities/2/
 * json: {
 * "id": 2,
 * "name": "Flutter learning",
 * "score": "6.66",
 * "desc": "Build a high-quality app by using Flutter with Dart during one week.",
 * "start_time": "2017-04-03T12:00:00",
 * "end_time": "2017-04-10T12:00:00",
 * "add_time": "2017-04-03T19:37:00"
 * }
 */
public class ActivityBean {

    private Integer id;

    private String name;
    private String score;
    private String desc;

    @SerializedName("start_time")
    private String startTime;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("add_time")
    private String addTime;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
