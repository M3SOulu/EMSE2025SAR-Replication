package edu.baylor.ecs.ems.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExamDto {
    private Integer id;
    private String examinee;
    private Integer issuer;
    private Integer configurationId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="US/Central")
    private Date examDate;

    public ExamDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExaminee() {
        return examinee;
    }

    public void setExaminee(String examinee) {
        this.examinee = examinee;
    }

    public Integer getIssuer() {
        return issuer;
    }

    public void setIssuer(Integer issuer) {
        this.issuer = issuer;
    }

    public Integer getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
