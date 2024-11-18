package edu.baylor.ecs.ems.dto;

public class CodeDto {

    private Integer id;
    private LanguageDto language;
    private String body;

    public CodeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LanguageDto getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDto language) {
        this.language = language;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
