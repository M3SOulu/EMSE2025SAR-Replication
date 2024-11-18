package edu.baylor.ecs.cms.controller;

import edu.baylor.ecs.cms.dto.EmailDto;
import edu.baylor.ecs.cms.dto.ExamDto;
import edu.baylor.ecs.cms.model.Exam;
import edu.baylor.ecs.cms.model.Question;
import edu.baylor.ecs.cms.model.User;
import edu.baylor.ecs.cms.service.EmsService;
import edu.baylor.ecs.cms.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private EmsService emsService;

    @Autowired
    private UmsService umsService;

    @CrossOrigin
    @PostMapping("/create")
    @RolesAllowed("user")
    public Object createExam(@RequestBody ExamDto object) {
        return emsService.createExam(object);
    }

    @CrossOrigin
    @GetMapping("/{email}")
    @RolesAllowed("user")
    public EmailDto isEmailValid(@PathVariable String email, @RequestHeader("Authorization") String authorication) {
        return umsService.isEmailValid(email, authorication);
    }
    @CrossOrigin
    @GetMapping("/users")
    @RolesAllowed("user")
    public List<Object> getAllUsers(@RequestHeader("Authorization") String authorication) {
        return umsService.getAllUsers(authorication);
    }

    @CrossOrigin
    @RequestMapping(path = "/{id}/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("user")
    public List<Question> getExamDetail(@PathVariable Integer id) {
        return emsService.getQuestionsForExam(id);
    }

    @CrossOrigin
    @GetMapping("")
    @RolesAllowed("user")
    public List<Exam> getAllExams() {
        System.out.println("getAllExams");
        //@RequestParam String username, @RequestParam String date,
//        String id = umsService.getExamineeId(username, auth);
        List<Exam> exams = emsService.getExams();
        return exams;
//        if (exams == null) {
//            return null;
//        }
//        return exams
//                .stream()
//                .filter(x -> (username == null || username.equals("")) || x.getExaminee().equals(id))
//                .filter(x -> (date == null || date.equals("")) || date.equals(x.getExamDate()))
//                .collect(Collectors.toList());
    }

//    @CrossOrigin(origins = "*")
//    @RequestMapping(path = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Exam> filterExams( @RequestHeader("Authorization") String auth) {
//        //@RequestParam String username, @RequestParam String date,
//        String id = umsService.getExamineeId(username, auth);
//        List<Exam> exams = emsService.getExams();
//        if (exams == null) {
//            return null;
//        }
//        return exams
//                .stream()
//                .filter(x -> (username == null || username.equals("")) || x.getExaminee().equals(id))
//                .filter(x -> (date == null || date.equals("")) || date.equals(x.getExamDate()))
//                .collect(Collectors.toList());
//    }

    @CrossOrigin
    @RequestMapping(path = "/getAllExamsInStatusINIT", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @RolesAllowed("user")
    public List<Exam> getAllExamsInStatusINIT() {
        return emsService.getINITExams();
    }

    @CrossOrigin
    @RequestMapping(path = "/deleteExam/{id}", method = RequestMethod.DELETE)
    @RolesAllowed("user")
    public String deleteExam(@PathVariable Integer id) {
        return emsService.deleteINITExam(id);
    }

    @CrossOrigin
    @RequestMapping(path = "/examineeById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("user")
    public User getExamineeById(@PathVariable String id, @RequestHeader("Authorization") String auth) {
        return umsService.getExamineeInfo(id, auth);
    }
}
