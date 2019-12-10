package com.fpt.hr_management.listener.request.allowances;

import com.fpt.hr_management.listener.response.BaseRequest;

public class AllowanceUpdateRequest extends BaseRequest {
	private int id;
	private int saTypeId;
	private long saTotalSalary;

	public AllowanceUpdateRequest() {

	}

	public AllowanceUpdateRequest(int id, int saTypeId, long saTotalSalary) {
		this.id = id;
		this.saTypeId = saTypeId;
		this.saTotalSalary = saTotalSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSaTypeId() {
		return saTypeId;
	}

	public void setSaTypeId(int saTypeId) {
		this.saTypeId = saTypeId;
	}

	public long getSaTotalSalary() {
		return saTotalSalary;
	}

	public void setSaTotalSalary(long saTotalSalary) {
		this.saTotalSalary = saTotalSalary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AllowancesUpdateRequest [id=").append(id).append(", saTypeId=").append(saTypeId)
				.append(", saTotalSalary=").append(saTotalSalary).append("]");
		return builder.toString();
	}

}
