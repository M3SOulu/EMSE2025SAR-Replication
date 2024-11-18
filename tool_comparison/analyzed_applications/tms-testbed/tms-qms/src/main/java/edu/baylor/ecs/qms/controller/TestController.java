package edu.baylor.ecs.qms.controller;


import edu.baylor.ecs.qms.model.ConfigurationGroup;
import edu.baylor.ecs.qms.model.dto.QuestionSingleCodeDto;
import edu.baylor.ecs.qms.repository.ConfigurationRepository;
import edu.baylor.ecs.qms.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private QuestionService questionService;

    @CrossOrigin
    @GetMapping("")
    @RolesAllowed("superadmin")
    public List<QuestionSingleCodeDto> createTest(@RequestParam("configId") Long configId) {
        List<QuestionSingleCodeDto> questions = new ArrayList<>();
        List<ConfigurationGroup> configurationGroups = configurationRepository.getAllGroupsById(configId);
        if(!configurationGroups.isEmpty()) {
            for(ConfigurationGroup group:configurationGroups) {
                questions.addAll(questionService.getQuestionSingleCodeDtosByConfigGroup(group));
            }
            return questions;
        }
        return null;
    }

}
