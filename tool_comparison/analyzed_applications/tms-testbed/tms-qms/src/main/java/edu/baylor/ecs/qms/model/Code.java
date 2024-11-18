package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "code")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "code_id_seq")
public class Code extends UUIDHashedEntityObject {

    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    @NotNull
    @Column(nullable = false)
    @Size(min = 3)
    private String body;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(updatable = false)
    private Question question;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
