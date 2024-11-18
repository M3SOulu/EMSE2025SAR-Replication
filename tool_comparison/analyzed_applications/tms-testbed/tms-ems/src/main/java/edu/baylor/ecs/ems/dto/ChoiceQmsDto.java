package edu.baylor.ecs.ems.dto;

public class ChoiceQmsDto {
    private Integer id;
    private String body;
    private boolean correct;

    public ChoiceQmsDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
