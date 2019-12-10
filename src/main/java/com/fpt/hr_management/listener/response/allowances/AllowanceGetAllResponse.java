package com.fpt.hr_management.listener.response.allowances;

public class AllowanceGetAllResponse {
	private int satId;
	private String satName;
	private String satDescription;

	public AllowanceGetAllResponse() {

	}

	public AllowanceGetAllResponse(int satId, String satName) {
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

	public String getSatDescription() {
		return satDescription;
	}

	public void setSatDescription(String satDescription) {
		this.satDescription = satDescription;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AllowancesGetAllResponse [satId=").append(satId).append(", satName=").append(satName)
				.append(", satDescription=").append(satDescription).append("]");
		return builder.toString();
	}

}
