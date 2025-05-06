package com.aithinkers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aithinkers.entity.Employee;
import com.aithinkers.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/listEmployee")
	public String listEmployees(Model model) {
		List<Employee> allEmployees = empService.findAllEmployees();
		model.addAttribute("employee", allEmployees);
		return "employees/employee-forum";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employees/employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empService.saveEmployeeDetails(emp);
		return "employees/employee-forum";
	}

	@GetMapping("/updateEmployee")
	public String showFormForUpdate(@RequestParam("employeeId") Integer id, Model model) {
	    Employee employee = empService.findEmployeeByID(id);
	    model.addAttribute("employee", employee);
	    return "employees/employee-form";
	}


	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") Integer id) {
		empService.deleteByid(id);
		return "redirect:/employees/list";


	}

}
