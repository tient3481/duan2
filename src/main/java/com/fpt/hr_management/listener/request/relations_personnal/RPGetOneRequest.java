package com.fpt.hr_management.listener.request.relations_personnal;

public class RPGetOneRequest {

	private int employee_id;

	public RPGetOneRequest() {

	}

	public RPGetOneRequest(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RelationsPersonal [employee_id=").append(employee_id).append("]");
		return builder.toString();
	}

}