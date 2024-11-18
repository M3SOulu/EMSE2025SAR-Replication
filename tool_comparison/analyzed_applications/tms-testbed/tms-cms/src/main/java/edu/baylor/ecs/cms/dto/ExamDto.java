package edu.baylor.ecs.cms.dto;

public class ExamDto {
    private Integer id;
    private String examinee;
    private String issuer;
    private String configurationId;
    private String examDate;

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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}
