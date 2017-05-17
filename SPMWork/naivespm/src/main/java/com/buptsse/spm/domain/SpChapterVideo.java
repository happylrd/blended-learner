package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sp_chapter_video")
public class SpChapterVideo implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "chapter_id", nullable = false)
    private int chapterId;

    @Column(name = "video_time")
    private int videoTime;

    @Column(name = "video_name_number", length = 32)
    private String videoNameNumber;

    @Column(name = "video_name", length = 128)
    private String videoName;

    @Column(name = "video_desc", length = 512)
    private String videoDesc;

    @Column(name = "video_path", length = 512)
    private String videoPath;

    @Column(name = "video_pic", length = 512)
    private String videoPic;

    @Column(name = "video_step_order")
    private int videoStepOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoNameNumber() {
        return videoNameNumber;
    }

    public void setVideoNameNumber(String videoNameNumber) {
        this.videoNameNumber = videoNameNumber;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoPic() {
        return videoPic;
    }

    public void setVideoPic(String videoPic) {
        this.videoPic = videoPic;
    }

    public int getVideoStepOrder() {
        return videoStepOrder;
    }

    public void setVideoStepOrder(int videoStepOrder) {
        this.videoStepOrder = videoStepOrder;
    }
}
