package edu.baylor.ecs.qms.repository;


import edu.baylor.ecs.qms.model.Question;
import edu.baylor.ecs.qms.model.dto.QuestionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(name = Question.FIND_BY_CATEGORYID_AND_NAME)
    List<QuestionDto> findByCategoryIdAndName (Long categoryId, String name);
    @Query(name = Question.FIND_DTO_BY_NAME)
    List<QuestionDto> findQuestionDtoByName(String name);
    @Query(name = Question.FIND_BY_CATEGORYID)
    List<Question> findByCategoryId(Long categoryId);
    @Query(name = Question.FIND_BY_CATEGORYID_LEVEL_LANGUAGE)
    List<Question> findByCategoryIdAndLevelAndLanguage(Long categoryId, Integer level, Long languageId);
}
