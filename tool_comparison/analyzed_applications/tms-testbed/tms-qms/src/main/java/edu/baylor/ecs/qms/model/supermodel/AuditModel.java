package edu.baylor.ecs.qms.model.supermodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdwhen", "modifiedwhen", "createdby","modifiedby"},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdwhen")
    @CreatedDate
    @JsonIgnore
    private Date createdWhen;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedwhen")
    @LastModifiedDate
    @JsonIgnore
    private Date modifiedWhen;

    @CreatedBy
    @Column(name = "createdby")
    @JsonIgnore
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "modifiedby")
    @JsonIgnore
    private Long modifiedBy;

    public Date getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(Date createdWhen) {
        this.createdWhen = createdWhen;
    }

    public Date getModifiedWhen() {
        return modifiedWhen;
    }

    public void setModifiedWhen(Date modifiedWhen) {
        this.modifiedWhen = modifiedWhen;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public AuditModel clone() throws CloneNotSupportedException {
        final AuditModel clone = (AuditModel) super.clone();
        clone.setCreatedBy(null);
        clone.setCreatedWhen(null);
        clone.setModifiedBy(null);
        clone.setModifiedWhen(null);
        return clone;
    }






}
