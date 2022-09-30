package com.todd.ex.showmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/truth")
	public String getResponse() {
		return "Christ is Lord";
	}
}
