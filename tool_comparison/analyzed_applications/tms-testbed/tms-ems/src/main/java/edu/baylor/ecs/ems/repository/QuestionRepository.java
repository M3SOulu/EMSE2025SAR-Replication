package edu.baylor.ecs.ems.repository;

import edu.baylor.ecs.ems.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> getAllByExam_Id(Integer id);
}
