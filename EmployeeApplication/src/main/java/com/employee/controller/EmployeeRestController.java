package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Credientials;
import com.employee.model.Employee;
import com.employee.service.CredentailsService;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	CredentailsService cs;
	
	@Autowired
	EmployeeService es;
	
	@PostMapping("/credientails")
	public Credientials addCredientails(@RequestBody Credientials c ) throws Exception {
		return cs.saveCrediantials(c);
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee e) {
		return es.saveEmployee(e);
	}
	
	@GetMapping("/employee/{name}")
	public Employee getOneEmployee(@PathVariable("name") String name) {
		return es.getByCrediantailsUserName(name);
	}
	@GetMapping("/credientails/{username}")
	public Credientials getCredientails(@PathVariable("username") String username) {
		return cs.findUser(username);
	}
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return es.allEmployees();
	}
	@GetMapping("/credientails")
	public List<Credientials> getAllCredientails(){
		return cs.allUsers();
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee e) {
		return es.updateEmployee(e);
	}
	
	
}
