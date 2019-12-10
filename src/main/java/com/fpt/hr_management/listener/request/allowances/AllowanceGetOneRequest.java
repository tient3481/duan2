package com.fpt.hr_management.listener.request.allowances;

public class AllowanceGetOneRequest {
	private int id;

	public AllowanceGetOneRequest() {
	}

	public AllowanceGetOneRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
