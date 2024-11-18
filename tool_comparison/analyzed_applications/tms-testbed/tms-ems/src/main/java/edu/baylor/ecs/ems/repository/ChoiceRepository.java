package edu.baylor.ecs.ems.repository;

import edu.baylor.ecs.ems.model.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {

    List<Choice> findByQuestionId(Integer id);
}
