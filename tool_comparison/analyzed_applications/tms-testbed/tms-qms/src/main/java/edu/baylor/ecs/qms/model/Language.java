package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "language")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "language_id_seq")
public class Language extends UUIDHashedEntityObject {

    @NotNull
    @Column(nullable = false)
    @Size(max = 256, min = 3)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
