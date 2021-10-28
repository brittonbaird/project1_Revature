package com.revature.project1.main;

import com.revature.project1.controller.EmployeeController;
import com.revature.project1.controller.RequestController;
import com.revature.project1.util.HibernateUtil;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	public static void main(String[] args) {
		
		HibernateUtil hibernate = new HibernateUtil();

		Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(7777);


		app.get("/login/{email}", EmployeeController.fetchByEmail);
		app.post("/employees", EmployeeController.saveEmployee);
		app.get("/employees", EmployeeController.fetchAllEmployees);
		
		app.get("/requests/{id}", RequestController.fetchById);
		app.get("/requests", RequestController.fetchAllRequests);
		app.post("/requests", RequestController.saveRequest);
		//make request update app.post
	}
}
