package edu.baylor.ecs.qms.controller;

import edu.baylor.ecs.qms.model.Category;
import edu.baylor.ecs.qms.model.dto.CategoryInfoDto;
import edu.baylor.ecs.qms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoryinfo")
public class CategoryInfoController {
    @Autowired
    private CategoryRepository categoryRepository;

    /*
     * UNRELATED ACCESS VIOLATION MUTANT
     */
    @CrossOrigin
    @GetMapping("")
    @RolesAllowed("user")
    public List<CategoryInfoDto> findAllCategoryInfos() {
        List<CategoryInfoDto> categoryInfoDtos = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories) {
            CategoryInfoDto categoryInfoDto = new CategoryInfoDto(category.getId(),category.getName(),category.getDescription(),categoryRepository.getQuestionCountDtoById(category.getId()));
            categoryInfoDtos.add(categoryInfoDto);
        }

        return categoryInfoDtos;
    }


}
