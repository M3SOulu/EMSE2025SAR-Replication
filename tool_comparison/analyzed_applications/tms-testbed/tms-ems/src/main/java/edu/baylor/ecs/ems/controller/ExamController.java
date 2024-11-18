package edu.baylor.ecs.ems.controller;

import edu.baylor.ecs.ems.dto.ExamDto;
import edu.baylor.ecs.ems.dto.QuestionEmsDto;
import edu.baylor.ecs.ems.model.Exam;
import edu.baylor.ecs.ems.model.Question;
import edu.baylor.ecs.ems.service.ExamService;
import edu.baylor.ecs.ems.service.UmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private UmsService umsService;

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    @RolesAllowed("user")
    public List<Exam> listAllExams() {
        List<Exam> exams = examService.findAllExams();
        if(exams.isEmpty()){
            return null;
        }
        return exams;
    }

    @CrossOrigin
    @RequestMapping(path = "/{id}/questions", method = RequestMethod.GET)
    public List<Question> listAllQuestionsForExam(@PathVariable Integer id) {
        return examService.getQuestionsForExam(id);
    }

//    @PreAuthorize("hasAnyAuthority('ROLE_ems-frontend')")
    @CrossOrigin
    @RequestMapping(value = "getByUsername/{username}", method = RequestMethod.GET)
    public List<Exam> getByUserName(@PathVariable String username, @RequestHeader("Authorization") String authorization) {
        System.out.println("get by username");
        System.out.println(username);
        String id = umsService.getExamineeId(username, authorization);
        System.out.println(id);
        List<Exam> exams = examService.findAllExams();
        if(exams.isEmpty()){
            return null;
        }
        return exams
                .stream()
                .filter(x -> x.getExaminee().equals(id))
                .collect(Collectors.toList());
    }

    //From CMS
    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Exam createExam(@RequestBody ExamDto examDto) {
        return examService.saveExam(examDto);
    }

    @CrossOrigin
    @RequestMapping(value = "/take/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionEmsDto> takeExam(@PathVariable("id") Integer id) {
        // check ID
        return examService.takeExam(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/submit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Exam submitExam(@PathVariable("id") Integer id) {
        // check ID
        return examService.submitExam(id);
    }

    // change status to done + calculate wrong / correct / sum of answers

    @CrossOrigin
    @RequestMapping(value = "/finish/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String finishExam(@PathVariable("id") Integer id) {
        // check ID
        return examService.finishExam(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Exam getExam(@PathVariable("id") Integer id) {
        // check ID
        return examService.findById(id).orElse(null);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteINITExam(@PathVariable Integer id) {
        if (!examService.deleteINITExam(id)) {
            return "Not found!";
        }
        return "Deleted exam with id " + id + " successfully.";
    }

}
