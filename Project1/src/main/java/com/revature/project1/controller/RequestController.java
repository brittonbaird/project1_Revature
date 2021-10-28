package com.revature.project1.controller;


import com.revature.project1.model.Request;
import com.revature.project1.service.RequestService;

import io.javalin.http.Handler;

public class RequestController {

	public static Handler fetchAllRequests = ctx -> {
		Iterable<Request> requests = RequestService.getRequests();
		ctx.json(requests);
	};
	
	public static Handler  fetchAllByEmployeeId = ctx ->{
		Iterable<Request> requests = RequestService.getRequestsByEmployeeId(Integer.parseInt(ctx.pathParam("id")));
		ctx.json(requests);
	};
	
	public static Handler fetchById = ctx -> {
		Request request = RequestService.getRequest(ctx.pathParam("id"));
		if (request == null) {
			ctx.html("Not Found");
		} else {
			ctx.json(request);
		}
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
