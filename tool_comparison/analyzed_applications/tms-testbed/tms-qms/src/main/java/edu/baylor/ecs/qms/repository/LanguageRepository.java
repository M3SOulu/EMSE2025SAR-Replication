package edu.baylor.ecs.qms.repository;

import edu.baylor.ecs.qms.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByName(String name);
}
