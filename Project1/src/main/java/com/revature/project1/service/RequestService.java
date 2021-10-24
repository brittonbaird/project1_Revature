package com.revature.project1.service;

import java.util.List;

import com.revature.project1.dao.RequestDAO;
import com.revature.project1.model.Request;

public class RequestService {
	public static void saveRequest(Request request) {
		RequestDAO.instance().saveRequest(request);
	}

	public static List<Request> getRequests() {
		List<Request> requests = RequestDAO.instance().getRequests();
		return requests;
	}
	
	public static void updateRequest(Request request) {
		RequestDAO.instance().updateRequest(request);
	}
}
