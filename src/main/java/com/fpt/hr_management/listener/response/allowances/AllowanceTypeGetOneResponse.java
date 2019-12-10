package com.fpt.hr_management.listener.response.allowances;

import com.fpt.hr_management.model.BaseEntity;

public class AllowanceTypeGetOneResponse extends BaseEntity {
	private int satId;
	private String satName;

	public AllowanceTypeGetOneResponse() {

	}

	public AllowanceTypeGetOneResponse(int satId, String satName) {
		this.satId = satId;
		this.satName = satName;
	}

	public int getSatId() {
		return satId;
	}

	public void setSatId(int satId) {
		this.satId = satId;
	}

	public String getSatName() {
		return satName;
	}

	public void setSatName(String satName) {
		this.satName = satName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AllowanceTypeGetOneResponse [satId=").append(satId).append(", satName=").append(satName)
				.append("]");
		return builder.toString();
	}

}
