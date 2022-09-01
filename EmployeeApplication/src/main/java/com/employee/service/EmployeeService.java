package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	BCryptPasswordEncoder bpc;
	
	//it will save employee in database
	public Employee saveEmployee(Employee employee){
		employee.getCredientails().setPassword(this.bpc.encode(employee.getCredientails().getPassword()));
		return employeeRepo.save(employee);
	}
	//it will find the employee based on the user name
	public Employee findEmployee(int employeeid){
		return employeeRepo.findById(employeeid).get();
	}
	//it will update the employee
	public Employee updateEmployee(Employee employee){
		Employee foundEmployee=employeeRepo.findById(employee.getEmployeeId()).get();
		return employeeRepo.save(employee);
	}
	//it will return the list of employees
	public List<Employee> allEmployees(){
		return employeeRepo.findAll();
	}
	//it will return the crediantails user name in employee table
	public Employee getByCrediantailsUserName(String name) {
		return employeeRepo.findBycredientails(name);
	}
	
	
}
