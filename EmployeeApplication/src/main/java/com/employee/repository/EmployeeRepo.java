package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//it will fetch the crediantails in the employee table
	@Query(value="select * from employee_credientails where  CREDIENTAILS_USER_NAME=?",nativeQuery = true)
	public Employee findBycredientails(String name);
	
}
