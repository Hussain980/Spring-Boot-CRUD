package com.hussain.crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.crud.Exception.ResourceNotFoundException;
import com.hussain.crud.entity.Employee;
import com.hussain.crud.repository.EmployeeRepository;
import com.hussain.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepo;


	@Override
	public Employee save(Employee e) {
		return empRepo.save(e);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}


	@Override
	public Employee getEmployeeById(Integer id) {
		Employee employee = empRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id  " + id));
		return employee;
	}


	@Override
	public Employee UpdateEmployee(Integer id, Employee employee) {
		Employee employeeDB = empRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id  " + id));
		employeeDB.setEmailId(employee.getEmailId());
		employeeDB.setFirstName(employee.getFirstName());
		employeeDB.setLastName(employee.getLastName());
		return empRepo.save(employeeDB);
	}


	@Override
	public void deleteEmployee(Integer id) {
		Employee employeeDB = empRepo.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id  " + id));
		empRepo.delete(employeeDB);
		
	}
	


}
