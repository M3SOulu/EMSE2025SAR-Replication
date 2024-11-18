package edu.baylor.ecs.qms.controller;

import edu.baylor.ecs.qms.Exception.ResourceNotFoundException;
import edu.baylor.ecs.qms.model.Category;
import edu.baylor.ecs.qms.model.Question;
import edu.baylor.ecs.qms.repository.CategoryRepository;
import edu.baylor.ecs.qms.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private QuestionRepository questionRepository;

    /*
     * UNRELATED ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @GetMapping("")
    @RolesAllowed({"moderator","admin","superadmin"})
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{cateogryId}")
    @RolesAllowed({"user","admin","superadmin"})
    public Category findCategoriesById(@PathVariable Long cateogryId) {
        return categoryRepository.findById(cateogryId).orElse(null);
    }

    /*
     * HIERARCHY ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @PostMapping("")
    @RolesAllowed({"user","admin","superadmin"})
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    /*
     * ENTITY ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @PutMapping("/{categoryId}")
    @RolesAllowed({"admin","superadmin"})
    public Category updateCategory(@PathVariable Long categoryId, @Valid @RequestBody Category categoryRequest) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.setName(categoryRequest.getName());
                    category.setDescription(categoryRequest.getDescription());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }

    /*
     * ENTITY ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @PutMapping("/{categoryId}")
    @RolesAllowed({"user", "admin","superadmin"})
    public Category updateCategoryName(@PathVariable Long categoryId, @Valid @RequestBody Category categoryRequest) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.setName(categoryRequest.getName());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }

    /*
     * HIERARCHY ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @DeleteMapping("/{cateogryId}")
    @RolesAllowed({"admin","superadmin"})
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.getQuestions().clear();
                    List<Question> questions = questionRepository.findByCategoryId(categoryId);
                    for (Question question:questions) {
                        question.getCategories().remove(category);
                        questionRepository.save(question);
                    }
                    categoryRepository.save(category);
                    categoryRepository.delete(category);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }
}
