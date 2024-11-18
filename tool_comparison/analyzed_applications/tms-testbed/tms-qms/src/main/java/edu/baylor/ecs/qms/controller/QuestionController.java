package edu.baylor.ecs.qms.controller;

import edu.baylor.ecs.qms.Exception.InstanceCreatingException;
import edu.baylor.ecs.qms.Exception.ResourceNotFoundException;
import edu.baylor.ecs.qms.model.*;
import edu.baylor.ecs.qms.model.dto.QuestionDto;
import edu.baylor.ecs.qms.repository.*;
import edu.baylor.ecs.qms.model.*;
import edu.baylor.ecs.qms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
@RolesAllowed({"admin","superadmin"})
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ChoiceRepository choiceRepository;
    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private LanguageRepository languageRepository;

    @CrossOrigin
    @RolesAllowed({"superadmin", "admin"})
    @GetMapping("/all")
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    @CrossOrigin
    @RolesAllowed({"superadmin", "admin"})
    @GetMapping("/{questionId}")
    public Question findQuestionById(@PathVariable Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @CrossOrigin
    @RolesAllowed({"uzer", "admin"})
    @GetMapping("")
    public List<QuestionDto> findQuestionByCateogryIdAndName(@RequestParam Map<String, Object> customQuery) {

        String name = "";
        if (customQuery.containsKey("name")) {
            name = customQuery.get("name").toString().toLowerCase();
        }

        List<QuestionDto> dtos = new ArrayList<>();
        if(customQuery.containsKey("categoryId")) {
            Long categoryId = Long.parseLong(customQuery.get("categoryId").toString());
            dtos = questionRepository.findByCategoryIdAndName(categoryId, "%" + name + "%");
        } else {
            dtos = questionRepository.findQuestionDtoByName("%" + name + "%");
        }

        for (QuestionDto dto : dtos) {
            dto.setCategoriesNames(categoryRepository.getNamesByQuestionId(dto.getId()));
        }
        return dtos;
    }

    @CrossOrigin
    @PostMapping("")
    @RolesAllowed({"superadmin", "admin"})
    public Question createQuestion(@Valid @RequestBody Map<String, Object> payload) {
        try {
            Question question = new Question();
            question.setBody((String) payload.get("body"));
            question.setLevel(Integer.parseInt(payload.get("level").toString()));
            question.setTitle((String) payload.get("title"));
            ArrayList<Object> categoryIds = (ArrayList<Object>) payload.get("categories");
            for (Object id : categoryIds) {
                Category category = categoryRepository.findById(Long.parseLong(id.toString())).orElse(null);
                if (category != null) {
                    question.getCategories().add(category);
                }
            }
            ArrayList<Map<String, Object>> choices = (ArrayList<Map<String, Object>>) payload.get("choices");
            for (Map<String, Object> choice : choices) {
                createNewChoiceFromJSonForQuestion(question, choice);
            }
            ArrayList<Map<String, Object>> codes = (ArrayList<Map<String, Object>>) payload.get("codes");
            for (Map<String, Object> code : codes) {
                createNewCodeFromJsonForQuestion(question, code);

            }
            return questionRepository.save(question);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InstanceCreatingException("Question created failed because of " + e.getMessage());
        }

    }

    @CrossOrigin
    @DeleteMapping("/{questionId}")
    @RolesAllowed({"admin", "superadmin"})
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }

    @CrossOrigin
    @RolesAllowed({"superadmin", "admin"})
    @PutMapping("/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId, @Valid @RequestBody Map<String, Object> payload) {
        try {
            Question question = questionRepository.findById(questionId).orElse(null);
            if (question == null) {
                throw new ResourceNotFoundException("Question not found with id " + questionId);
            }
            question.setTitle(payload.get("title").toString());
            question.setBody(payload.get("body").toString());
            question.setLevel(Integer.parseInt(payload.get("level").toString()));
            Set<Choice> choicesInDB = question.getChoices();
            HashSet<Long> choicesInDBIds = new HashSet<>();
            for (Choice c : choicesInDB) {
                choicesInDBIds.add(c.getId());
            }
            ArrayList<Map<String, Object>> choices = (ArrayList<Map<String, Object>>) payload.get("choices");

            HashSet<Long> updatedChoicesId = new HashSet<>();
            for (Map<String, Object> choice : choices) {
                if (choice.containsKey("id")) {
                    updatedChoicesId.add(Long.parseLong(choice.get("id").toString()));
                }
            }

            Iterator<Choice> it = choicesInDB.iterator();
            ArrayList<Choice> deleteChoices = new ArrayList<>();
            while (it.hasNext()) {
                Choice c = it.next();
                if (updatedChoicesId.add(c.getId())) {
                    deleteChoices.add(c);
                    it.remove();
                }
            }
            for(Choice c: deleteChoices) {
                question.getChoices().remove(c);
                choiceRepository.delete(c);
            }

            for (Map<String, Object> choice : choices) {
                if (!choice.containsKey("id")) {
                    createNewChoiceFromJSonForQuestion(question, choice);
                }
                else if (choicesInDBIds.add(Long.parseLong(choice.get("id").toString()))) {
                    createNewChoiceFromJSonForQuestion(question, choice);
                } else {
                    updateChoiceFromJSonForQuestion(choicesInDB, choice);
                }
            }

            Set<Code> codesInDB = question.getCodes();
            HashSet<Long> codesInDBIds = new HashSet<>();
            for (Code c : codesInDB) {
                codesInDBIds.add(c.getId());
            }
            ArrayList<Map<String, Object>> codes = (ArrayList<Map<String, Object>>) payload.get("codes");


            HashSet<Long> updatedcodesId = new HashSet<>();
            for (Map<String, Object> code : codes) {
                if(code.containsKey("id")) {
                    updatedcodesId.add(Long.parseLong(code.get("id").toString()));
                }
            }
            Iterator<Code> iter = codesInDB.iterator();
            ArrayList<Code> deleteCodes = new ArrayList<>();
            while (iter.hasNext()) {
                Code c = iter.next();
                if (updatedcodesId.add(c.getId())) {
                    deleteCodes.add(c);
                    iter.remove();
                }
            }

            for(Code c:deleteCodes) {
                question.getCodes().remove(c);
                codeRepository.delete(c);
            }


            for (Map<String, Object> code : codes) {
                if (!code.containsKey("id")) {
                    createNewCodeFromJsonForQuestion(question, code);
                }
                else if (codesInDBIds.add(Long.parseLong(code.get("id").toString()))) {
                    createNewCodeFromJsonForQuestion(question, code);
                } else {
                    updateCodeFromJsonForQuestion(codesInDB, code);
                }

            }


            Set<Category> categoriesInDB = question.getCategories();
            HashSet<Long> categoriesIdsInDB = new HashSet<>();
            ArrayList<Object> categoryIds = (ArrayList<Object>) payload.get("categories");
            ArrayList<Long> categoryIdsLong = categoryIds.stream().map(c->Long.parseLong(c.toString())).collect(Collectors.toCollection(ArrayList::new));

            Iterator<Category> catIter = categoriesInDB.iterator();
            ArrayList<Category> deleteCategories = new ArrayList<>();
            while (catIter.hasNext()) {
                Category c = catIter.next();
                if(!categoryIdsLong.contains(c.getId())){
                    deleteCategories.add(c);
                    catIter.remove();
                }
            }
            for(Category c:deleteCategories) {
                question.getCategories().remove(c);
            }


            for(Category c:categoriesInDB) {
                categoriesIdsInDB.add(c.getId());
            }

            for(Long id:categoryIdsLong) {
                if(categoriesIdsInDB.add(id)) {
                    Category c = categoryRepository.findById(id).orElse(null);
                    if(c!=null){
                        question.getCategories().add(c);
                    }

                }
            }


            return questionRepository.save(question);

        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InstanceCreatingException("Question updating failed because of " + e.getMessage());
        }

    }

    private void createNewCodeFromJsonForQuestion(Question question, Map<String, Object> code) {
        Long languageId = Long.parseLong(code.get("languageId").toString());
        Language language = languageRepository.findById(languageId).orElse(null);
        if (language != null) {
            Code c = new Code();
            c.setBody(code.get("body").toString());
            c.setLanguage(language);
            c.setQuestion(question);
            question.getCodes().add(c);
        }
    }

    private void updateCodeFromJsonForQuestion(Set<Code> codesInDB, Map<String, Object> code) {
        for (Code c : codesInDB) {
            if(c.getId()==null) {
                continue;
            }
            if (c.getId().equals(Long.parseLong(code.get("id").toString()))) {
                Long languageId = Long.parseLong(code.get("languageId").toString());
                Language language = languageRepository.findById(languageId).orElse(null);
                if (language != null) {
                    c.setBody(code.get("body").toString());
                    c.setLanguage(language);
                }
            }
        }
    }

    private void createNewChoiceFromJSonForQuestion(Question question, Map<String, Object> choice) {
        Choice c = new Choice();
        c.setBody(choice.get("body").toString());
        c.setCorrect(Boolean.parseBoolean(choice.get("correct").toString()));
        c.setQuestion(question);
        question.getChoices().add(c);
    }

    private void updateChoiceFromJSonForQuestion(Set<Choice> choicesInDB, Map<String, Object> choice) {
        for (Choice c : choicesInDB) {
            if(c.getId()==null) {
                continue;
            }
            if (c.getId().equals(Long.parseLong(choice.get("id").toString()))) {
                c.setBody(choice.get("body").toString());
                c.setCorrect(Boolean.parseBoolean(choice.get("correct").toString()));
            }
        }
    }


}
