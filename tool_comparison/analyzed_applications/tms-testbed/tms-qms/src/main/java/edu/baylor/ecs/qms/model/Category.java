package edu.baylor.ecs.qms.model;

import edu.baylor.ecs.qms.model.supermodel.UUIDHashedEntityObject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "category")
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "idgen", sequenceName = "category_id_seq")
@NamedQueries({
        @NamedQuery(name = Category.FIND_NAMES_BY_QUESTION_ID,
                query = "select c.name from Category c join c.questions q where q.id = ?1"),
        @NamedQuery(name = Category.FIND_QUESTION_COUNT_DTO_BY_ID,
                query = "select new baylor.csi.questionManagement.model.dto.QuestionCountDto(q.level, l.name, count(q)) from Category c join c.questions q join q.codes code join code.language l where c.id = ?1 group by (q.level,l.name) order by (q.level,l.name) asc"),
})
public class Category extends UUIDHashedEntityObject {

    public static final String FIND_NAMES_BY_QUESTION_ID = "FIND_NAMES_BY_QUESTION_ID";
    public static final String FIND_QUESTION_COUNT_DTO_BY_ID = "FIND_QUESTION_COUNT_DTO_BY_ID";

    @NotNull
    @Column(nullable = false)
    @Size(max = 256, min = 3)
    private String name;

    @NotNull
    @Column(nullable = false)
    @Size(min = 3)
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Question> questions = new HashSet<>();

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

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
