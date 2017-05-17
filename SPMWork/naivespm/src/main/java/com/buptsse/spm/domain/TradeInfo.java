package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tradeinfo")
public class TradeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idtradeinfo", nullable = false)
    private int idTradeInfo;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", length = 2000)
    private String content;

    public int getIdTradeInfo() {
        return idTradeInfo;
    }

    public void setIdTradeInfo(int idTradeInfo) {
        this.idTradeInfo = idTradeInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
