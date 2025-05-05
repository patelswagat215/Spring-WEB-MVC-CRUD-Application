package com.aithinkers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aithinkers.entity.Employee;
import com.aithinkers.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/list")
	public String listEmployees(Model model)
	{
		//Getting the data from the database
		List<Employee> allEmployees = empService.findAllEmployees();
		
		//Add the data to the model,so that in view files we will access it
		model.addAttribute("Employees",allEmployees);
		
		//Return to the employee-forum and access employees data.
		return "employees/employees-forum";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model)
	{
		Employee emp=new Employee();
		
		model.addAttribute("Employee",emp);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
	    // Save the employee using service
	    empService.saveEmployeeDetails(emp);

	    // Redirect to prevent duplicate form submission
	    return "redirect:/employees/list";
	}

}
