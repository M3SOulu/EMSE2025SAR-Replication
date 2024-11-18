package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "person")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "person_id_seq")
public class Person extends UUIDHashedEntityObject {
    private String userName;
    private String firstName;
    private String lastName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
