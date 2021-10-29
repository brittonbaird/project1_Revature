package com.revature.project1.service;

import java.util.List;


import com.revature.project1.dao.RequestDAO;

import com.revature.project1.model.Request;
import com.revature.project1.util.LoggerUtil;

public class RequestService {
	public static void saveRequest(Request request) {
		LoggerUtil.getLogger().info("Saving Request: " + request);
		RequestDAO.instance().saveRequest(request);
	}

	public static List<Request> getRequests() {
		LoggerUtil.getLogger().info("Getting all Requests");
		List<Request> requests = RequestDAO.instance().getRequests();
		return requests;
	}
	
	public static List<Request> getRequestsByEmployeeId(int id) {
		LoggerUtil.getLogger().info("Getting Request by employee id: " + id);
		List<Request> requests = RequestDAO.instance().getRequestsByEmployeeId(id);
		return requests;
	}
	
	public static Request getRequest(String id) {
		LoggerUtil.getLogger().info("Getting Request by id: " + id);
		Request request = RequestDAO.instance().getRequest(Integer.parseInt(id));
		return request;
	}
	
	public static void updateRequest(Request request) {
		LoggerUtil.getLogger().info("Updating request" + request);
		RequestDAO.instance().updateRequest(request);
	}
}
