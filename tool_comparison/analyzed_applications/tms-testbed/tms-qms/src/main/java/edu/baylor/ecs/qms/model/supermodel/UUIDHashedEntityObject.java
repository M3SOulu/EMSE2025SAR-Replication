package edu.baylor.ecs.qms.model.supermodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@MappedSuperclass
public abstract class UUIDHashedEntityObject extends IdEntityObject implements Cloneable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -8116216227510729282L;

    /**
     * The key. Uninitialized at beginning. It is initialized automatically when one
     * of the methods {@link #getUUID()}, {@link #hashCode()} or {@link #equals(Object)}
     * is called.
     */
    private UUID uuid;

    /**
     * Gets the UUID. Random value that should be unique and identify each row.
     *
     * @return The UUID.
     */
    @JsonIgnore
    @NotNull
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(nullable = false, unique = true)
    public UUID getUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }

        return uuid;
    }

    /**
     * Sets the new value of UUID. Note that setting UUID to null will cause this value
     * to be overwritten with first call of {@link #getUUID()}, {@link #hashCode()} or
     * {@link #equals(Object)}.
     *
     * @param uuid New value to set. Do not use {@code null}.
     */
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Calculates the hash code using the {@link #uuid} hash code.
     */
    @Override
    public int hashCode() {
        return getUUID().hashCode();
    }

    /**
     * Equals done by comparing two uuids.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        //JSF compares objects with their proxies, that's why we cannot compare getClass() directly.
        //We have to make sure that obj can be compared using UUID.
        if (!UUIDHashedEntityObject.class.isInstance(obj))
            return false;

        final UUIDHashedEntityObject other = (UUIDHashedEntityObject) obj;
        return getUUID().equals(other.getUUID());
    }

    @Override
    public UUIDHashedEntityObject clone() throws CloneNotSupportedException {
        final UUIDHashedEntityObject clone = (UUIDHashedEntityObject) super.clone();
        clone.setUUID(null);
        return clone;
    }
}
