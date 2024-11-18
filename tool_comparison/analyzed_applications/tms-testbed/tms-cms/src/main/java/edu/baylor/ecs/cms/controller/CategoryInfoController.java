package edu.baylor.ecs.cms.controller;

import edu.baylor.ecs.cms.dto.CategoryInfoDto;
import edu.baylor.ecs.cms.service.QmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.RolesAllowed;

import java.util.List;

@RestController
@RequestMapping("/categoryInfo")
public class CategoryInfoController {

    @Autowired
    private QmsService qmsService;

    @CrossOrigin
    @RequestMapping("")
    @RolesAllowed("user")
    public List<Object> getCategoryInfo() {
        return qmsService.getCategoryInfoDtos();
    }
}
