package com.aithinkers.service;

import java.util.List;

import com.aithinkers.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	Employee findEmployeeByID(Integer id);

	Employee saveEmployeeDetails(Employee employee);

	void deleteByid(Integer id);

}
