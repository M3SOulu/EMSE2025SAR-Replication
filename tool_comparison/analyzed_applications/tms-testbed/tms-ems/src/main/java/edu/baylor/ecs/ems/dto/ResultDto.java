package edu.baylor.ecs.ems.dto;

public class ResultDto {

    private Integer correct;

    private Integer wrong;

    public ResultDto(){}

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getWrong() {
        return wrong;
    }

    public void setWrong(Integer wrong) {
        this.wrong = wrong;
    }
}
