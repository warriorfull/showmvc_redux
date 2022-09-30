package com.todd.ex.showmvc.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.todd.ex.showmvc.service.WelcomeService;

@WebMvcTest // use because it is Integration Test
public class WelcomeControllerIntegrationTest {

	// What to test?
	// integration the controller, method welcome() and Spring
	
	@Autowired
	private MockMvc mockMvc;
	
	// mockBean for WelcomeService - because purpose is to:
	//  to test our method and the Spring stuff we put around it.
	//  We are not actually testing the welcomeService yet.
	@MockBean  
	private WelcomeService welcomeService;
	
	@Test
	void shouldGetDefaultMessage() throws Exception {
		when(welcomeService.getWelcomeMessage("Stranger"))
			.thenReturn("Welcome Stranger!");
		mockMvc.perform(get("/welcome"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Welcome Stranger!")));
		verify(welcomeService).getWelcomeMessage("Stranger");
	}
	
	@Test
	void shouldGetCustomMessage() throws Exception {
		when(welcomeService.getWelcomeMessage("John"))
			.thenReturn("Welcome John!");
		mockMvc.perform(get("/welcome?name=John"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Welcome John!")));
		verify(welcomeService).getWelcomeMessage("John");
	}
}
