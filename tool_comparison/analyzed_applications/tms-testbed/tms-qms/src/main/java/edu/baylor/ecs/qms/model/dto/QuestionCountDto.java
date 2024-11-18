package edu.baylor.ecs.qms.model.dto;

public class QuestionCountDto {
    private Integer level;
    private String language;
    private Long count;

    public QuestionCountDto(Integer level, String language, Long count) {
        this.level = level;
        this.language = language;
        this.count = count;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
