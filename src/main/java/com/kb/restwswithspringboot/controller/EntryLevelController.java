package com.kb.restwswithspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryLevelController {
	
	@RequestMapping("/test")
	public String test(){
		return "Hello!";
	}
	

}
