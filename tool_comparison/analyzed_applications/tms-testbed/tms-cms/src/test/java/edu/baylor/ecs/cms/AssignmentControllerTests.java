package edu.baylor.ecs.cms;



//<<<<<<< HEAD
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//
//
//=======
//import edu.baylor.ecs.cms.controller.AssignmentController;
//imimport edu.baylor.ecs.cms.service.AssignmentServices;
//import edu.baylor.ecs.cms.dto.AssignmentDto;
//import edu.baylor.ecs.cms.model.Assignment;
//import edu.baylor.ecs.cms.model.Configuration;
//import edu.baylor.ecs.cms.service.AssignmentService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
//>>>>>>> 1f6457cfaf9e85b488175b3d56ccf21a9c073726
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//<<<<<<< HEAD
//=======
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//>>>>>>> 1f6457cfaf9e85b488175b3d56ccf21a9c073726


@SpringBootTest
@AutoConfigureMockMvc
public class AssignmentControllerTests {

//<<<<<<< HEAD
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AssignmentController assignmentService;
//
//
//
//    @Test
//    public void retrieveAllAssginmentServices() throws Exception {
//        when(assignmentService.listAllAssignments()).thenReturn("The assignmnets have been retrieved");
//        this.mockMvc.perform(get("/assignment/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The assignmnets have been retrieved")));
//    }
//
//
//
//    @Test
//    public void retrievesingleAssginmentServices() throws Exception {
//        when(assignmentService.getAssignment()).thenReturn("The assignmnet has been retrieved");
//        this.mockMvc.perform(get("/assignment/{id}")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The assignmnet has been retrieved")));
//    }
//
//
//
//
//
//    @Test
//    public void retrievedtoAssginmentServices() throws Exception {
//        when(assignmentService.getDtoAssignment()).thenReturn("The DTO assignmnet has been retrieved");
//        this.mockMvc.perform(get("/assignment-dto/{id}")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The DTO assignmnet has been retrieved")));
//    }
//
//
//    @Test
//    public void createAssignmentServices() throws Exception {
//        when(assignmentService.createAssignment()).thenReturn("The assignment has been created");
//        this.mockMvc.perform(post("/assignment/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The assignment has been created")));
//    }
//
//
//
//
//    @Test
//    public void updateAssignmentServices() throws Exception {
//        when(assignmentService.updateAssignment()).thenReturn("The assignment has been updated");
//        this.mockMvc.perform(put("/assignment/{id}")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The assignment has been updated")));
//    }
//
//
//    @Test
//    public void deleteAssignmentServices() throws Exception {
//        when(assignmentService.deleteAssignment()).thenReturn("The assignment has been deleted");
//        this.mockMvc.perform(delete("/assignment/{id}")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The assignment has been deleted")));
//    }
//=======
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AssignmentService assignmentService;
//
//
//
//    //1
//
//
//    @Test
//    public void test_get_all_assignments() throws Exception {
//
//
//        Configuration configration=new Configuration();
//
//        List<Assignment> assignment = Arrays.asList(
//                new Assignment(1, "abd","tomas",configration),
//                new Assignment(2, "jan","john",configration);
//
//
//
//
//
//
//        when(assignmentService.findAllAssignments()).thenReturn(assignment);
//        mockMvc.perform(get("/assignment/"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].student", is("abd")))
//                .andExpect(jsonPath("$[0].teacher", is("tomas")))
//                .andExpect(jsonPath("$[0].configuration", is(configration)))
//                .andExpect(jsonPath("$[0].id", is(2)))
//                .andExpect(jsonPath("$[0].student", is("jan")))
//                .andExpect(jsonPath("$[0].teacher", is("john")))
//                .andExpect(jsonPath("$[0].configuration", is(configration)))
//            ;
//        verify(assignmentService, times(1)).findAllAssignments();
//        verifyNoMoreInteractions(assignmentService);
//    }
//
//    //2
//
//
//    @DisplayName("assignment is ok")
//    @Test
//    public void shouldReturnAssginment() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(1);
//
//        this.mockMvc.perform(get("/assignment/{id}", assignment))
//                .andExpect(status().isOk());
//    }
//
//
//    @DisplayName("assginment not found")
//    @Test
//    public void assginmentSetNotFound() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(2);
//
//        this.mockMvc.perform(get("/assignment/{id}", assignment))
//                .andExpect(status().isNotFound());
//    }
//
//
//    //3
//
//
//
//    @DisplayName("assignment DTO is ok")
//    @Test
//    public void shouldReturnDTOAssginment() throws Exception {
//
//        AssignmentDto assignmentdto = new AssignmentDto();
//        assignmentdto.setId(1);
//
//        this.mockMvc.perform(get("/assignment-dto/{id}", assignmentdto))
//                .andExpect(status().isOk());
//    }
//
//
//    @DisplayName("assginment DTO not found")
//    @Test
//    public void assginmentDTOSetNotFound() throws Exception {
//
//        AssignmentDto assignmentdto = new AssignmentDto();
//        assignmentdto.setId(2);
//
//        this.mockMvc.perform(get("/assignment-dto/{id}", assignmentdto))
//                .andExpect(status().isNotFound());
//    }
//
//
//
//
////4
//
//
//    @Test
//    public void shouldcreateAssginment() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(1);
//
//        this.mockMvc.perform(post("/assignment/{id}", assignment))
//                .andExpect(status().isOk());
//    }
//
//
//
//    @Test
//    public void assginmnetisConflict() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(2);
//
//        this.mockMvc.perform(post("/assignment/{id}", assignment))
//                .andExpect(status().isConflict());
//    }
//>>>>>>> 1f6457cfaf9e85b488175b3d56ccf21a9c073726
//
//
//
//
////5
//
//    @Test
//    public void shouldupdateAssginment() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(1);
//
//        this.mockMvc.perform(put("/assignment/{id}", assignment))
//                .andExpect(status().isOk());
//    }
//
//
//
//    @Test
//    public void assginmnetupdateisnotFound() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(2);
//
//        this.mockMvc.perform(put("/assignment/{id}", assignment))
//                .andExpect(status().isNotFound());
//    }
//
//    //6
//
//
//
//    @Test
//    public void shouldDeleteAssginment() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(1);
//
//        this.mockMvc.perform(delete("/assignment/{id}", assignment))
//                .andExpect(status().isOk());
//    }
//
//
//
//    @Test
//    public void assginmnetContentisnotFound() throws Exception {
//
//        Assignment assignment = new Assignment();
//        assignment.setId(2);
//
//        this.mockMvc.perform(delete("/assignment/{id}", assignment))
//                .andExpect(status().isNotFound());
//    }











}


