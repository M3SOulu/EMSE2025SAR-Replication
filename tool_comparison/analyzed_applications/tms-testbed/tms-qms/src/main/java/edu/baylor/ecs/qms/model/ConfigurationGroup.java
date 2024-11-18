package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "configurationgroup")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "configurationgroup_id_seq")
public class ConfigurationGroup extends UUIDHashedEntityObject {
    private Long category;
    private Integer level;
    private Integer count;
    private Long languageId;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(updatable = false)
    private Configuration configuration;

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
