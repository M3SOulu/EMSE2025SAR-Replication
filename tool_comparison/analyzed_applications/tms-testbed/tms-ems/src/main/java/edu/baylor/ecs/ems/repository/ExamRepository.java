package edu.baylor.ecs.ems.repository;

import edu.baylor.ecs.ems.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamRepository extends JpaRepository<Exam, Integer> {

    Boolean existsByExamineeAndId(Integer examinee, Integer id);
}