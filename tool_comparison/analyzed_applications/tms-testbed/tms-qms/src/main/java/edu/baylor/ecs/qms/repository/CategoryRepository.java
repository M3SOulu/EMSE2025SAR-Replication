package edu.baylor.ecs.qms.repository;

import edu.baylor.ecs.qms.model.Category;
import edu.baylor.ecs.qms.model.dto.QuestionCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(name = Category.FIND_NAMES_BY_QUESTION_ID)
    List<String> getNamesByQuestionId(Long id);
    @Query(name = Category.FIND_QUESTION_COUNT_DTO_BY_ID)
    List<QuestionCountDto> getQuestionCountDtoById(Long id);

}
