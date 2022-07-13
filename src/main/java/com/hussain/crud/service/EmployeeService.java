package com.hussain.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hussain.crud.entity.Employee;

@Service
public interface EmployeeService {

	Employee save(Employee e);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Integer id);
	
	Employee UpdateEmployee(Integer id , Employee employee);
	
	void deleteEmployee(Integer id);
}
