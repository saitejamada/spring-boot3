package com.tutorial.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {

	@RequestMapping("/home")
	public String goHome() {
		return "Homepage";
	}
	@RequestMapping("/python")
	public String home() {
		return "PythonHomePage";
	}
	@RequestMapping("/Introduction")
	public String intro() {
		return "Introduction";
	}
	@RequestMapping("/inheritance")
	public String inheritance() {
		return "InheritanceOfJava";
	}
	@RequestMapping("/datatypes")
	public String dataTypes() {
		return "DataTypesOfJava";
	}
}
