package com.revature.project1.controller;

import java.util.List;
import java.util.Objects;

import org.hibernate.internal.build.AllowSysOut;

import com.google.gson.Gson;
import com.revature.project1.dao.EmployeeDAO;
import com.revature.project1.model.Employee;
import com.revature.project1.service.EmployeeService;

import io.javalin.http.Handler;

public class EmployeeController {

	
private static Gson gson = new Gson();
	
	public static Handler fetchAllEmployees = ctx -> {
		List<Employee> employees = EmployeeService.getEmployees();
		
		ctx.json(employees);
	};

	public static Handler fetchByEmail = ctx -> {
		System.out.println(ctx.pathParam("email"));
		Employee employee = EmployeeService.getEmployee(ctx.pathParam("email"));
		if (employee == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(employee);
		}
	};
	
}