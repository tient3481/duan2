package com.fpt.hr_management.listener.request.leave;

import com.fpt.hr_management.listener.response.BaseRequest;

public class LeaveUpdateRequest extends BaseRequest {

	private int idRecord;
	private int accept_status;
	private String employee_accept;

	public LeaveUpdateRequest() {

	}

	public LeaveUpdateRequest(int idRecord, int accept_status, String employee_accept, String last_modifier_by) {
		super();
		this.idRecord = idRecord;
		this.accept_status = accept_status;
		this.employee_accept = employee_accept;
		this.last_modifier_by = last_modifier_by;
	}

	public int getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(int idRecord) {
		this.idRecord = idRecord;
	}

	public int getAccept_status() {
		return accept_status;
	}

	public void setAccept_status(int accept_status) {
		this.accept_status = accept_status;
	}

	public String getEmployee_accept() {
		return employee_accept;
	}

	public void setEmployee_accept(String employee_accept) {
		this.employee_accept = employee_accept;
	}

	public String getLast_modifier_by() {
		return last_modifier_by;
	}

	public void setLast_modifier_by(String last_modifier_by) {
		this.last_modifier_by = last_modifier_by;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveUpdateRequest [idRecord=").append(idRecord).append(", accept_status=")
				.append(accept_status).append(", employee_accept=").append(employee_accept)
				.append(", last_modifier_by=").append(last_modifier_by).append("]");
		return builder.toString();
	}

}
