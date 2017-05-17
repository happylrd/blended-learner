package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "download")
public class DownLoad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "statement", length = 200)
    private String statement;

    @Column(name = "filepath", nullable = false, length = 100)
    private String filePath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
