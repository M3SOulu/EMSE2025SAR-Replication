package edu.baylor.ecs.qms.model;


import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "choice")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "choice_id_seq")
public class Choice extends UUIDHashedEntityObject {

    private String body;

    private Boolean correct;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(updatable = false)
    private Question question;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
