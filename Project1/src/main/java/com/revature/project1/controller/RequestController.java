package com.revature.project1.controller;

import java.util.List;

import com.revature.project1.dao.RequestDAO;
import com.revature.project1.model.Employee;
import com.revature.project1.model.Request;
import com.revature.project1.service.EmployeeService;
import com.revature.project1.service.RequestService;

import io.javalin.http.Handler;

public class RequestController {

	public static Handler fetchAllRequests = ctx -> {
		Iterable<Request> requests = RequestService.getRequests();
		ctx.json(requests);
	};

	public static Handler saveRequest = ctx -> {
		Request request = ctx.bodyAsClass(Request.class);
		
		if (request == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(request);
		}
		RequestService.saveRequest(request);
	};
	
	public static Handler updateRequest = ctx -> {
		Request request = ctx.bodyAsClass(Request.class);
		if (request == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(request);
		}
		RequestService.updateRequest(request);
	};
}
