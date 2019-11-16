package com.fpt.hr_management.listener.response.department;

public class DepartmentEmployeeGetOneResponse {
	private String employeeName;
	private String employeeTypeName;
	private String departmentName;
	private String departmentPhone;
	private String departmentLocation;
	private String positionName;

	private int employeeDepartmentId;
	private int employeeTypeId;
	private int departmentId;
	private int positionId;

	private String start_date;
	private String end_date;

	public DepartmentEmployeeGetOneResponse() {
		super();
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}

	public void setEmployeeDepartmentId(int employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}

	public int getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(int employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentEmployeeGetOneResponse [employeeName=").append(employeeName)
				.append(", employeeTypeName=").append(employeeTypeName).append(", departmentName=")
				.append(departmentName).append(", departmentPhone=").append(departmentPhone)
				.append(", departmentLocation=").append(departmentLocation).append(", positionName=")
				.append(positionName).append(", employeeDepartmentId=").append(employeeDepartmentId)
				.append(", employeeTypeId=").append(employeeTypeId).append(", departmentId=").append(departmentId)
				.append(", positionId=").append(positionId).append(", start_date=").append(start_date)
				.append(", end_date=").append(end_date).append("]");
		return builder.toString();
	}

}