package com.revature.project1.controller;

import java.util.List;

import com.revature.project1.model.Employee;

import com.revature.project1.service.EmployeeService;


import io.javalin.http.Handler;

public class EmployeeController {

	public static Handler fetchAllEmployees = ctx -> {
		List<Employee> employees = EmployeeService.getEmployees();

		ctx.json(employees);
	};

	public static Handler fetchByEmail = ctx -> {
		Employee employee = EmployeeService.getEmployee(ctx.pathParam("email"));
		if (employee == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(employee);
		}
	};

	public static Handler saveEmployee = ctx -> {
		Employee employee = ctx.bodyAsClass(Employee.class);
		
		if (employee == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(employee);
		}
		EmployeeService.saveEmployee(employee);
	};

}