package edu.baylor.ecs.qms.model.supermodel;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@MappedSuperclass
public class IdEntityObject extends AuditModel implements ICPCEntity {
    /**
     * The serial version UID.
     *
     * @see Serializable
     */
    private static final long serialVersionUID = 5553924130305731516L;

    protected Long id;

    protected Integer version = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    @JsonIgnore
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public IdEntityObject clone() throws CloneNotSupportedException {
        final IdEntityObject clone = (IdEntityObject) super.clone();
        clone.setId(null);
        clone.setVersion(0);
        return clone;
    }
}


