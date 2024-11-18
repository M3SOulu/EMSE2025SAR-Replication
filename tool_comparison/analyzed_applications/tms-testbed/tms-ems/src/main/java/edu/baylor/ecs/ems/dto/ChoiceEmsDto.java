package edu.baylor.ecs.ems.dto;

public class ChoiceEmsDto {
    private Integer id;
    private String body;
    private boolean chosen;

    public ChoiceEmsDto(){}

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

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
