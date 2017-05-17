package com.buptsse.spm.domain;

import java.io.Serializable;

public class SchedulePK implements Serializable {

    private int chapterId;

    private int videoStepOrder;

    private String userId;

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getVideoStepOrder() {
        return videoStepOrder;
    }

    public void setVideoStepOrder(int videoStepOrder) {
        this.videoStepOrder = videoStepOrder;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchedulePK that = (SchedulePK) o;

        return chapterId == that.chapterId && videoStepOrder == that.videoStepOrder
                && (userId != null ? userId.equals(that.userId) : that.userId == null);
    }

    @Override
    public int hashCode() {
        int result = chapterId;
        result = 31 * result + videoStepOrder;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
