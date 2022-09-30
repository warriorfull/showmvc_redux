package com.todd.ex.showmvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.todd.ex.showmvc.service.WelcomeService;

public class WelcomeControllerUnitTest {

	@Test
	void shouldTrue() {
		assertTrue(true);
	}

	@Test
	void shouldWelcome() {
		WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
		when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John!");
		when(welcomeService.getWelcomeMessage("")).thenReturn("Welcome Stranger!");
		
		WelcomeController welcomeController = new WelcomeController(welcomeService);	
		assertEquals("Welcome John!", welcomeController.welcome("John"));

		welcomeController = new WelcomeController(welcomeService);
		assertEquals("Welcome Stranger!", welcomeController.welcome(""));
	}
}
