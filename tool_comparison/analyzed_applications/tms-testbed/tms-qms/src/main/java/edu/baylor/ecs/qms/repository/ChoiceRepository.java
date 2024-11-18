package edu.baylor.ecs.qms.repository;

import edu.baylor.ecs.qms.model.Choice;
import edu.baylor.ecs.qms.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    List<Choice> findByQuestion(Question question);
}
