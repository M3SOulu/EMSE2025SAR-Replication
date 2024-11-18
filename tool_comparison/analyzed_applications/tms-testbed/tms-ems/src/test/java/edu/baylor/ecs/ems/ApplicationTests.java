package edu.baylor.ecs.ems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ExamService examService;
//
//
//	@DisplayName("Test Spring @Autowired Integration")
//	@Test
//	void testCreateExam() {
////		Exam exam = new Exam();
////
////		assertEquals("start", helloService.startParsing());
//	}
//
//	@DisplayName("Test Spring @Autowired Integration")
//	@Test
//	public void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(
//						(ResultMatcher) content().string(containsString("Hello World"))
//				);
//	}



}
