package edu.baylor.ecs.qms.repository;

import edu.baylor.ecs.qms.model.Code;
import edu.baylor.ecs.qms.model.Language;
import edu.baylor.ecs.qms.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long> {
    Code findByQuestionAndAndLanguage(Question question, Language language);
}
