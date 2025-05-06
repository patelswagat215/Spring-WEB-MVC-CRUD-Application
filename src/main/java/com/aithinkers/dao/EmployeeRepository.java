package com.aithinkers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aithinkers.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	//Add a method to sort by lastName Asc
	public List<Employee> findAllByOrderByLastNameAsc();

}
