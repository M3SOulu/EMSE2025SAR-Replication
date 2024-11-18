package edu.baylor.ecs.ems.dto;

import java.util.List;

public class SelectedChoiceEmsDto {
    private Integer examId;
    private Integer questionId;
    private List<ChoiceEmsDto> choiceEmsDtos;

    public SelectedChoiceEmsDto(){}

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public List<ChoiceEmsDto> getChoiceEmsDtos() {
        return choiceEmsDtos;
    }

    public void setChoiceEmsDtos(List<ChoiceEmsDto> choiceEmsDtos) {
        this.choiceEmsDtos = choiceEmsDtos;
    }
}
