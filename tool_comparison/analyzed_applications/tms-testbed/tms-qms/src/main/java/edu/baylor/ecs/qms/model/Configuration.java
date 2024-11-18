package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "configuration")
@NamedQueries({
        @NamedQuery(name = Configuration.FIND_ALL_GROUPS_BY_ID,
                query = "select g from Configuration c join c.groups g where c.id = ?1")
        })
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "configuration_id_seq")
public class Configuration extends UUIDHashedEntityObject {

    public static final String FIND_ALL_GROUPS_BY_ID = "FIND_ALL_GROUPS_BY_ID";

    private String name;
    private String description;

    @OneToMany(mappedBy = "configuration", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<ConfigurationGroup> groups = new HashSet<>();

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

    public Set<ConfigurationGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<ConfigurationGroup> groups) {
        this.groups = groups;
    }
}
