package edu.baylor.ecs.ums.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This is an extremely barebones DTO for keycloak
 * roles. It only wraps the name of the role, and is used
 * to communicate with the UMS frontend.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
@Entity
public class Role {

    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
