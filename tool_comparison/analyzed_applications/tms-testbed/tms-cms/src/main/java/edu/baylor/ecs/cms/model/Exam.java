package edu.baylor.ecs.cms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.baylor.ecs.cms.dto.ExamDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "exam")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Integer id;

    @Column(name="examinee")
    private String examinee;

    @Column(name="issuer")
    private String issuer;

    @Column(name="configuration_id")
    private String configurationId;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="US/Central")
    private String examDate;

    @Column(name="status")
    private ExamStatus status;

    @Column(name = "correct")
    private Integer correct;

    @Column(name = "sum")
    private Integer sum;

    public Exam(){}

    public Exam(ExamDto examDto){
        this.examinee = examDto.getExaminee();
        this.examDate = examDto.getExamDate();
        this.issuer = examDto.getIssuer();
        this.configurationId = examDto.getConfigurationId();
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

    public ExamStatus getStatus() {
        return status;
    }

    public void setStatus(ExamStatus status) {
        this.status = status;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;
        Exam exam = (Exam) o;
        return Objects.equals(getId(), exam.getId()) &&
                Objects.equals(getExaminee(), exam.getExaminee()) &&
                Objects.equals(getIssuer(), exam.getIssuer()) &&
                Objects.equals(getConfigurationId(), exam.getConfigurationId()) &&
                Objects.equals(getExamDate(), exam.getExamDate()) &&
                getStatus() == exam.getStatus() &&
                Objects.equals(getCorrect(), exam.getCorrect()) &&
                Objects.equals(getSum(), exam.getSum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExaminee(), getIssuer(), getConfigurationId(), getExamDate(), getStatus(), getCorrect(), getSum());
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examinee='" + examinee + '\'' +
                ", issuer=" + issuer +
                ", configurationId=" + configurationId +
                ", examDate=" + examDate +
                ", status=" + status +
                ", correct=" + correct +
                ", sum=" + sum +
                '}';
    }
}
