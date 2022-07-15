package com.hussain.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.crud.entity.Employee;
import com.hussain.crud.serviceImpl.EmployeeServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empService;
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.save(employee);
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		Employee employee = empService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
		Employee emp = empService.UpdateEmployee(id, employee);
		return ResponseEntity.ok(emp);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Integer id){
		empService.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
