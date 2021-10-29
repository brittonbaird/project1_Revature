package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.model.Employee;
import com.revature.project1.util.LoggerUtil;


public class EmployeeService {
	public static List<Employee> getEmployees() {
		LoggerUtil.getLogger().info("Getting Employee list");
		List<Employee> employees = EmployeeDAO.instance().getEmployees();
		return employees;
	}
	
	public static Employee getEmployee(String email) {
		LoggerUtil.getLogger().info("Getting Employee with email:" + email);
		Employee employee = EmployeeDAO.instance().getEmployee(email);
		return employee;
	}
	
	public static void saveEmployee(Employee employee) {
		LoggerUtil.getLogger().info("Saving Employee: " + employee);
		EmployeeDAO.instance().saveEmployee(employee);
	}
}

