package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "code")
public class Code implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "codeType", length = 50)
    private String codeType;

    @Column(name = "codeCode", length = 50)
    private String codeCode;

    @Column(name = "codeName", length = 50)
    private String codeName;

    @Column(name = "validate", length = 1)
    private String validate;

    @Column(name = "remark", length = 200)
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeCode() {
        return codeCode;
    }

    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
