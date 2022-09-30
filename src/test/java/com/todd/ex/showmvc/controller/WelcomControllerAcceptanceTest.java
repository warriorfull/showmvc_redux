package com.todd.ex.showmvc.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// inject service into the controller
@SpringBootTest
@AutoConfigureMockMvc
public class WelcomControllerAcceptanceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldGetDefaultMessage() throws Exception {
//		when(welcomeService.getWelcomeMessage("Stranger"))
//			.thenReturn("Welcome Stranger!");
		mockMvc.perform(get("/welcome"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Welcome Stranger!")));
//		verify(welcomeService).getWelcomeMessage("Stranger");
	}
	
	@Test
	void shouldGetCustomMessage() throws Exception {
//		when(welcomeService.getWelcomeMessage("John"))
//			.thenReturn("Welcome John!");
		mockMvc.perform(get("/welcome?name=John"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Welcome John!")));
//		verify(welcomeService).getWelcomeMessage("John");
	}	
}
