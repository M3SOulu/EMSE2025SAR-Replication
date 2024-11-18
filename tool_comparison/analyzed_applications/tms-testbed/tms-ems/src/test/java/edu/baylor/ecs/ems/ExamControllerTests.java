package edu.baylor.ecs.ems;

//import ExamController;
//import ExamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
//import static org.hamcrest.Matchers.is;

//
//@SpringBootTest
//@AutoConfigureMockMvc
public class ExamControllerTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ExamService examService;
//
//    @Autowired
//    private ExamController examController;





//<<<<<<< HEAD
//
//    @DisplayName("Test Spring @Autowired Integration")
//    @Test
//    public void shouldReturnAnswerDTO() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(1);
//
//        this.mockMvc.perform(post("/exam/take/{id}", answerDto))
//                .andExpect(status().isOk());
//    }
//
//
//    @DisplayName("Exam associated with Question not found")
//    @Test
//    public void examSetNotFound() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(2);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isNotFound());
//    }
//
//
//
//
//
//
//
//@DisplayName("Test Spring @Autowired Integration")
//    @Test
//    public void shouldReturnAnswerDTO() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(1);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isOk());
//    }
//
//
//    @DisplayName("Exam associated with Question not found")
//    @Test
//    public void examSetNotFound() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(2);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isNotFound());
//    }
//
//    @DisplayName("Test Spring @Autowired Integration")
//    @Test
//    public void examSetBadRequest() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(3);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isBadRequest());
//    }







//
//    @Test
//    public void setChoiceServices() throws Exception {
//        when(examControllerMock.setAnswerWithChoice()).thenReturn("The exam has been updated");
//        this.mockMvc.perform(put("/exam/set")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The exam has been updated")));
//    }
//
//    @Test
//    public void retrieveExamServices() throws Exception {
//        when(examControllerMock.listAllExams()).thenReturn("The exams have been retrieved");
//        this.mockMvc.perform(get("/exam/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The exams have been retrieved")));
//    }
//
//    @Test
//    public void createExamServices() throws Exception {
//        when(examControllerMock.createExam()).thenReturn("The exam has been created");
//        this.mockMvc.perform(post("/exam/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("The exam has been created")));
//    }
//=======
//
////1
//
//
//
//
//    @Test
//    public void test_get_all_successs() throws Exception {
//
//
//
//
//        List<ChoiceQmsDto> choicedto = Arrays.asList(
//                new ChoiceQmsDto(1, "math"),
//                new ChoiceQmsDto(2, "science");
//
//
//        List<QuestionQmsDto> questiondto = Arrays.asList(
//                new QuestionQmsDto(1, "math",choicedto),
//                new QuestionQmsDto(2, "science",choicedto));
//
//
//
//        when(examService.findAllExams()).thenReturn(questiondto);
//        mockMvc.perform(get("/exam/take/{id}"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].text", is("math")))
//                .andExpect(jsonPath("$[0].choiceDtos", is("math,science")))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].text", is("science")))
//                .andExpect(jsonPath("$[1].choiceDtos", is("math,science")));
//        verify(examService, times(1)).findAllExams();
//        verifyNoMoreInteractions(examService);
//    }
//
//
//
//
//    //2
//
//
//
//
//
//@DisplayName("Test Spring @Autowired Integration")
//    @Test
//    public void shouldReturnAnswerDTO() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(1);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isOk());
//    }
//
//
//    @DisplayName("Exam associated with Question not found")
//    @Test
//    public void examSetNotFound() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(2);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isNotFound());
//    }
//
//    @DisplayName("Test Spring @Autowired Integration")
//    @Test
//    public void examSetBadRequest() throws Exception {
//
//        AnswerDto answerDto = new AnswerDto();
//        answerDto.setId(3);
//
//        this.mockMvc.perform(post("/exam/set", answerDto))
//                .andExpect(status().isBadRequest());
//    }
//
//
//
////3
//
//
//    @Test
//    public void test_get_all_exam() throws Exception {
//
//
//
//
//        List<Exam> exam = Arrays.asList(
//                new Exam(1, "abc",1,7,3,"10:00","11:00","DONE"),
//                new Exam(2, "xyz",2,8,2,"10:00","11:00","DONE");
//
//
//
//
//
//
//        when(examService.findAllExams()).thenReturn(exam);
//        mockMvc.perform(get("/exam/"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].student", is("abc")))
//                .andExpect(jsonPath("$[0].assignment", is(1)))
//                .andExpect(jsonPath("$[0].wrongAnswers", is(7)))
//                .andExpect(jsonPath("$[0].rightAnswers", is(3)))
//                .andExpect(jsonPath("$[0].timeStarted", is("10:00")))
//                .andExpect(jsonPath("$[0].timeFinished", is("11:00")))
//                .andExpect(jsonPath("$[0].status", is("DONE")))
//                .andExpect(jsonPath("$[1].id", is(1)))
//                .andExpect(jsonPath("$[1].student", is("xyz")))
//                .andExpect(jsonPath("$[1].assignment", is(2)))
//                .andExpect(jsonPath("$[1].wrongAnswers", is(8)))
//                .andExpect(jsonPath("$[1].rightAnswers", is(2)))
//                .andExpect(jsonPath("$[1].timeStarted", is("10:00")))
//                .andExpect(jsonPath("$[1].timeFinished", is("11:00")))
//                .andExpect(jsonPath("$[1].status", is("DONE")));
//        verify(examService, times(1)).findAllExams();
//        verifyNoMoreInteractions(examService);
//    }
//
////4
//
//
//    @Test
//    public void shouldcreateExam() throws Exception {
//
//        Exam exam = new Exam();
//        exam.setId(1);
//
//        this.mockMvc.perform(post("/exam/", exam))
//                .andExpect(status().isOk());
//    }
//
//
//
//    @Test
//    public void examisConflict() throws Exception {
//
//        Exam exam = new Exam();
//        exam.setId(2);
//
//        this.mockMvc.perform(post("/exam/", exam))
//                .andExpect(status().isConflict());
//    }
//>>>>>>> 8b0bec76f615d2510d0c19ba9ff314f26b4b3105








}







