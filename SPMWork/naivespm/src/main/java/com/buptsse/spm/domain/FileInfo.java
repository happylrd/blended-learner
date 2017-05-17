package com.buptsse.spm.domain;

import javax.persistence.*;

@Entity
@Table(name = "fileinfo")
public class FileInfo {

    @Id
    @GeneratedValue
    @Column(name = "idfile", nullable = false)
    private int id;

    @Column(name = "filePath", length = 100)
    private String filePath;

    @Column(name = "filename", length = 100)
    private String filename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
