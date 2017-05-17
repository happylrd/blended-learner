package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sp_chapter")
public class SpChapter implements Serializable {

    @Id
    @Column(name = "chapter_id", nullable = false)
    private int chapterId;

    @Column(name = "chapter_name_number")
    private int chapterNameNumber;

    @Column(name = "chapter_name", length = 64)
    private String chapterName;

    @Column(name = "chapter_desc", length = 256)
    private String chapterDesc;

    @Column(name = "chapter_pic", length = 256)
    private String chapterPic;

    @Column(name = "chapter_courseware", length = 256)
    private String chapterCourseware;

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getChapterNameNumber() {
        return chapterNameNumber;
    }

    public void setChapterNameNumber(int chapterNameNumber) {
        this.chapterNameNumber = chapterNameNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }

    public String getChapterPic() {
        return chapterPic;
    }

    public void setChapterPic(String chapterPic) {
        this.chapterPic = chapterPic;
    }

    public String getChapterCourseware() {
        return chapterCourseware;
    }

    public void setChapterCourseware(String chapterCourseware) {
        this.chapterCourseware = chapterCourseware;
    }
}
