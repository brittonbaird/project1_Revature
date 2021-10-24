package com.revature.project1.model;

public class Request {
	private int id;
	private int employeeId;
	private String reason;
	private String status;
	private double amount;
	
	public Request() {
		super();
	}
	
	public Request(int id, int employeeId, String reason, String status, double amount) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.reason = reason;
		this.status = status;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
