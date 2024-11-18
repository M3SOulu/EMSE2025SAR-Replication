package edu.baylor.ecs.qms.model.dto;

import java.util.List;

public class QuestionDto {
    private Long id;
    private String name;
    private List<String> categoriesNames;
    private Integer level;

    public QuestionDto(Long id, String name, Integer level) {
        this.id = id;
        this.name = name;
        this.level = level;
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

    public List<String> getCategoriesNames() {
        return categoriesNames;
    }

    public void setCategoriesNames(List<String> categoriesNames) {
        this.categoriesNames = categoriesNames;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
