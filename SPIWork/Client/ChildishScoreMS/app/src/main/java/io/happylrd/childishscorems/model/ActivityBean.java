package io.happylrd.childishscorems.model;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * url: http://localhost:8000/activities/2/
 * json: {
 * "id": 2,
 * "name": "Flutter learning",
 * "score": "6.66",
 * "desc": "Build a high-quality app by using Flutter with Dart during one week.",
 * "has_passed": false,
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

    @SerializedName("has_passed")
    private Boolean hasPassed;

    @SerializedName("start_time")
    private Date startTime;

    @SerializedName("end_time")
    private Date endTime;

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

    public Boolean getHasPassed() {
        return hasPassed;
    }

    public void setHasPassed(Boolean hasPassed) {
        this.hasPassed = hasPassed;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
