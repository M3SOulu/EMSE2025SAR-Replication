package edu.baylor.ecs.cms.dto;

import java.util.List;

public class ConfigurationDto {

    private String name;
    private String description;
    private List<GroupDto> groups;

    public ConfigurationDto(){}

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

    public List<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }
}
