package com.revature.project1.main;

import com.revature.project1.controller.EmployeeController;
import com.revature.project1.controller.RequestController;
import com.revature.project1.service.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(7777);

//		app.get("/hello", ctx -> ctx.html("<h1>Welcome to Javalin</h1>"));

//    	app.get("/users", EmployeeController.fetchAllUsernames);
//		app.get("/users/{id}", EmployeeController.fetchById);
//		app.post("/users", EmployeeController.addUser);

		app.get("/login/{email}", EmployeeController.fetchByEmail);
		app.get("/requests", RequestController.fetchAllRequests);
		app.post("/requests", RequestController.saveRequest);
//		app.get("/statistics", null);
//		app.post("/request", null);
	}
}
