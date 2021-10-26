package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.model.Employee;


public class EmployeeService {
	public static List<Employee> getEmployees() {
		List<Employee> employees = EmployeeDAO.instance().getEmployees();
		return employees;
	}
	
	public static Employee getEmployee(String email) {
		Employee employee = EmployeeDAO.instance().getEmployee(email);
		return employee;
	}
	
	public static void saveEmployee(Employee employee) {
		EmployeeDAO.instance().saveEmployee(employee);
	}
}

