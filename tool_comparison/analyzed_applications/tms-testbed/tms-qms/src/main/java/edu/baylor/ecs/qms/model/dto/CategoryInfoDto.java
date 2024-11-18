package edu.baylor.ecs.qms.model.dto;

import java.util.List;

public class CategoryInfoDto {
    private Long id;
    private String name;
    private String description;
    private List<QuestionCountDto> questionCountDtos;

    public CategoryInfoDto(Long id, String name, String description, List<QuestionCountDto> questionCountDtos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questionCountDtos = questionCountDtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<QuestionCountDto> getQuestionCountDtos() {
        return questionCountDtos;
    }

    public void setQuestionCountDtos(List<QuestionCountDto> questionCountDtos) {
        this.questionCountDtos = questionCountDtos;
    }
}
