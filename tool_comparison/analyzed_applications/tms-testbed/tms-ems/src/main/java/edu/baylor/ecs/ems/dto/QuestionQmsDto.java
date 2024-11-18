package edu.baylor.ecs.ems.dto;

import java.util.List;

public class QuestionQmsDto {

    private Integer id;

    private String title;

    private Integer level;

    private String body;

    private List<ChoiceQmsDto> choices;

    private CodeDto code;

    public QuestionQmsDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<ChoiceQmsDto> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceQmsDto> choices) {
        this.choices = choices;
    }

    public CodeDto getCode() {
        return code;
    }

    public void setCode(CodeDto code) {
        this.code = code;
    }

}
