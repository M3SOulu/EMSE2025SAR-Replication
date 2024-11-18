package edu.baylor.ecs.ems.controller;

import edu.baylor.ecs.ems.dto.SelectedChoiceEmsDto;
import edu.baylor.ecs.ems.model.Choice;
import edu.baylor.ecs.ems.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

import java.util.List;

@RestController
@RequestMapping("choice")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @RolesAllowed("user")
    public List<Choice> updateChoices(@RequestBody SelectedChoiceEmsDto selectedChoiceEmsDto) {
        return choiceService.selectChoices(selectedChoiceEmsDto);
    }

}
