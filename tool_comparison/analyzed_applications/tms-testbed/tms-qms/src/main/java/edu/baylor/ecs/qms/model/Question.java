package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "question_id_seq")
@NamedQueries({
        @NamedQuery(name = Question.FIND_BY_CATEGORYID_AND_NAME,
                query = "select new baylor.csi.questionManagement.model.dto.QuestionDto(q.id,q.title,q.level) from Question q join q.categories c where c.id = ?1 and lower(q.title) like ?2"),
        @NamedQuery(name = Question.FIND_DTO_BY_NAME,
                query = "select new baylor.csi.questionManagement.model.dto.QuestionDto(q.id,q.title,q.level) from Question q  where lower(q.title) like ?1"),
        @NamedQuery(name = Question.FIND_BY_CATEGORYID,
                query = "select q from Question q join q.categories c where c.id = ?1"),
        @NamedQuery(name = Question.FIND_BY_CATEGORYID_LEVEL_LANGUAGE,
                query = "select q from Question q join q.categories c join q.codes code join code.language l where c.id = ?1 and q.level= ?2 and l.id= ?3"),
})
public class Question extends UUIDHashedEntityObject {
    public static final String FIND_BY_CATEGORYID_AND_NAME = "FIND_BY_CATEGORYID_AND_NAME";
    public static final String FIND_DTO_BY_NAME = "FIND_DTO_BY_NAME";
    public static final String FIND_BY_CATEGORYID = "FIND_BY_CATEGORYID";
    public static final String FIND_BY_CATEGORYID_LEVEL_LANGUAGE = "FIND_BY_CATEGORYID_LEVEL_LANGUAGE";

    @NotNull
    @Column(nullable = false)
    @Size(max = 256, min = 3)
    private String title;

    @NotNull
    @Column(nullable = false)
    @Min(1)@Max(5)
    private Integer level;

    @NotNull
    @Column(nullable = false)
    @Size(min = 3)
    private String body;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Choice> choices = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Code> codes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private Set<Category> categories = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
