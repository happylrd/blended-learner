package io.happylrd.childishscorems.model;

import com.google.gson.annotations.SerializedName;

/**
 * url: http://localhost:8000/studentactivities/2/
 * json: {
 * "id": 2,
 * "student": 5,
 * "activity": 2,
 * "has_joined": true,
 * "has_finished": false,
 * "add_time": "2017-04-03T19:58:00"
 * }
 */
public class StudentActivityBean {

    private Integer id;

    @SerializedName("student")
    private Integer studentId;

    @SerializedName("activity")
    private Integer activityId;

    @SerializedName("has_joined")
    private Boolean hasJoined;

    @SerializedName("has_finished")
    private Boolean hasFinished;

    @SerializedName("add_time")
    private String addTime;

    public Integer getId() {
        return id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Boolean getHasJoined() {
        return hasJoined;
    }

    public void setHasJoined(Boolean hasJoined) {
        this.hasJoined = hasJoined;
    }

    public Boolean getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(Boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
