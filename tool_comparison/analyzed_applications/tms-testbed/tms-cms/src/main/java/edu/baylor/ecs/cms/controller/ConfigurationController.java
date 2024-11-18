package edu.baylor.ecs.cms.controller;

import edu.baylor.ecs.cms.dto.ConfigurationDto;
import edu.baylor.ecs.cms.service.QmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private QmsService qmsService;

    @CrossOrigin
    @PostMapping("")
    @RolesAllowed("user")
    public Object createConfiguration(@RequestBody ConfigurationDto object) {
        ResponseEntity<Object> tmp = qmsService.createConfiguration(object);
        return tmp.getBody();
    }

    @CrossOrigin
    @GetMapping("")
    @RolesAllowed("user")
    public Object[] getConfigurations() {
        return qmsService.getConfigurations().getBody();
    }

    //ToDo: update, delete


}
