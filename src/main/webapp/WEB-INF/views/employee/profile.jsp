<%@page import="java.util.Map"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>XTEL INTERNAL</title>

<link
	href="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<link
	href="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->

<!-- Custom styles for this template-->
<link
	href="https://blackrockdigital.github.io/startbootstrap-sb-admin/css/sb-admin.css"
	rel="stylesheet" type="text/css">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1"
			href="${pageContext.request.contextPath}/api/account/login">XTEL</a>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/api/employee/update/${accountName}">${accountName}-
						${roleName}</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/api/account/forgot-password">Quên
						mật khẩu</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/api/account/logout">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<c:if test="${roleId ==1}">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/api/employee/get"> <i
						class="fas fa-fw fa-home"></i> <span>Home</span>
				</a></li>
			</c:if>

			<c:if test="${roleId !=1}">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/api/employee/update/${accountId}">
						<i class="fas fa-fw fa-home"></i> <span>Home</span>
				</a></li>
			</c:if>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>Metadata</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Danh mục</h6>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/login">Nhóm kỹ
						năng</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/skill/get">Kỹ
						năng</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/skill/#">Phòng
						ban </a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/skill/#">Danh
						mục nghỉ phép </a>

					<div class="dropdown-divider"></div>

					<!-- <h6 class="dropdown-header">Other Pages:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a> <a
						class="dropdown-item" href="blank.html">Blank Page</a> -->
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-calendar-alt"></i>
					<span>Thông tin chung</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Danh mục</h6>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/update/${accountId}">Thông
						tin cá nhân</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/update/${accountId}">Thông
						tin nhân thân</a>
					<div class="dropdown-divider"></div>

				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-calendar-alt"></i>
					<span>Chấm công</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Danh mục</h6>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/checkin">Thông
						tin chấm công</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/leave/get">Thống
						kê ngày nghỉ</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/leave/add">Đăng
						ký nghỉ</a>

					<div class="dropdown-divider"></div>

				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-coins"></i> <span>Bảng
						lương</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Danh mục quản lý</h6>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/salary/get/${accountId}">Danh
						sách bảng lương</a>
					<div class="dropdown-divider"></div>

				</div></li>

		</ul>

		<!-- Content -->
		<div class="container-fluid"
			style="padding-left: 100px; padding-right: 100px;">
			<div class="row my-4">
				<div style="width: 100%">
					<ul class="nav nav-tabs">

						<!-- 		<li class="nav-item"><a href="" data-target="#account"
							data-toggle="tab" class="nav-link active">Thông tin tài khoản</a></li>
 -->
						<li class="nav-item"><a href="" data-target="#profile"
							data-toggle="tab" class="nav-link active">Thông tin cơ bản</a></li>

						<li class="nav-item"><a href="" data-target="#department"
							data-toggle="tab" class="nav-link">Thông tin phòng ban</a></li>

						<li class="nav-item"><a href="" data-target="#skill"
							data-toggle="tab" class="nav-link">Thông tin kỹ năng</a></li>

						<li class="nav-item"><a
							href="${pageContext.request.contextPath}/api/employee/leave/get"
							data-target="#leave" data-toggle="tab" class="nav-link">Thông
								tin nghỉ phép</a></li>

						<li class="nav-item"><a href="" data-target="#rp"
							data-toggle="tab" class="nav-link">Thông tin nhân thân</a></li>


						<li class="nav-item"><a href="" data-target="#allowance"
							data-toggle="tab" class="nav-link">Các khoản trợ cấp</a></li>

						<li class="nav-item"><a href="" data-target="#slr"
							data-toggle="tab" class="nav-link">Xem bảng lương</a></li>

					</ul>
					<div class="tab-content py-2">
						<!-- 	<div class="tab-pane " id="account">Updating</div>
 -->
						<div class="tab-pane active" id="profile">
							<form action="${pageContext.request.contextPath}/api/employee">

								<c:forEach var="infoEmployee" items="${infoEmployee}">
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">First
											name</label>
										<div class="col-lg-9">
											<input name="first_name" class="form-control" type="text"
												value="${infoEmployee.getFirst_name()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Middle
											name</label>
										<div class="col-lg-9">
											<input name="middle_name" class="form-control" type="text"
												value="${infoEmployee.getMiddle_name()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Last
											name</label>
										<div class="col-lg-9">
											<input name="last_name" class="form-control" type="text"
												value="${infoEmployee.getLast_name()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Dob</label>
										<div class="col-lg-9">
											<input name="dob" class="form-control" type="date"
												value="${infoEmployee.getDob()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Gender</label>
										<fieldset data-role="controlgroup">
											<c:if test="${infoEmployee.getSex() == 0}">
												<label class="col-lg-9" for="male">Male</label>
												<input type="radio" name="gender" value="0"
													checked="checked">
											</c:if>

											<c:if test="${infoEmployee.getSex() == 1}">
												<label class="col-lg-9" for="female">Female</label>
												<input type="radio" name="gender" value="1"
													checked="checked">
											</c:if>

										</fieldset>

									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Email</label>
										<div class="col-lg-9">
											<input name="email" class="form-control" type="email"
												value="${infoEmployee.getEmail()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Address</label>
										<div class="col-lg-9">
											<input name="address" class="form-control" type="text"
												value="${infoEmployee.getAddress()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Phone</label>
										<div class="col-lg-9">
											<input name="phone" class="form-control" type="number"
												value="${infoEmployee.getPhone()}">
										</div>
									</div>

									<div class="form-group row">
										<label for="exampleFormControlSelect1"
											class="col-lg-3 col-form-label form-control-label">Employee
											type</label>
										<div class="col-lg-9">
											<select class="custom-select" id="gender2"
												name="employee_type_id">
												<option value="1">Internship</option>
												<option value="2">Trail</option>
												<option value="3">Official</option>
											</select>
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Status</label>
										<fieldset data-role="controlgroup">
											<label class="col-lg-9" for="male">Working</label> <input
												type="radio" name="status" value="0"> <label
												class="col-lg-9" for="female">Left</label> <input
												type="radio" name="status" value="1"
												checked="${infoEmployee.getStatus()}">
										</fieldset>

									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Employee
											date</label>
										<div class="col-lg-9">
											<input name="employee_date" class="form-control" type="date"
												value="${infoEmployee.getEmployee_date()}" placeholder="">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">End
											date</label>
										<div class="col-lg-9">
											<input name="end_date" class="form-control" type="date"
												value="${infoEmployee.getEnd_date()}" placeholder="">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Description</label>
										<div class="col-lg-9">
											<input name="note" class="form-control" type="text"
												value="${infoEmployee.getNote()}">
										</div>
									</div>

									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Lương
											cơ bản</label>
										<div class="col-lg-9">
											<input name="base_salary" class="form-control" type="text"
												value="${infoEmployee.getSalary_base()}">
										</div>
									</div>

								</c:forEach>

								<div class="form-group row">
									<label class="col-lg-3 col-form-label form-control-label"></label>
									<div class="col-lg-9">
										<button type="submit" name="updateAccount"
											class="btn btn-outline-success">Save</button>

									</div>
								</div>

								<c:if test="${not empty message}">
									<div class="alert alert-${alerted}" role="alert">
										Thông báo! <a href="#" class="alert-link"> ${message} </a>
									</div>
								</c:if>
							</form>
						</div>

						<!-- ACCOUNT DEPARTMENT INFO -->
						<div class="tab-pane" id="department">
							<c:if test="${listEmployeeDepartment.size() > 0}">
								<table class="table">
									<thead>
										<tr>
											<th scope="col">Employee name</th>
											<th scope="col">Employee type</th>
											<th scope="col">Department name</th>
											<th scope="col">Department phone</th>
											<th scope="col">Department location</th>
											<th scope="col">Position name</th>
											<th scope="col">Start date</th>
											<th scope="col">End date</th>
											<c:if test="${roleId == 1 || roleId == 2}">
												<th scope="row"
													style="padding-left: 200px; margin-bottom: 20px;">Thao
													tác</th>

												<c:if test="${listEmployeeDepartment.size() >= 0}">
													<th><a
														href="${pageContext.request.contextPath}/api/employee/department/add/${idAccount}"><button
																type="button" style="float: right;"
																class="btn btn-success px-3">
																<i class="fa fa-plus" aria-hidden="true"></i>
															</button></a></th>
												</c:if>
											</c:if>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${listEmployeeDepartment}">
											<tr>
												<td scope="row">${list.getEmployeeName()}</td>
												<td scope="row">${list.getEmployeeTypeName()}</td>
												<td scope="row">${list.getDepartmentName()}</td>
												<td scope="row">${list.getDepartmentPhone()}</td>
												<td scope="row">${list.getDepartmentLocation()}</td>
												<td scope="row">${list.getPositionName()}</td>
												<c:choose>
													<c:when test="${list.getStart_date() != null}">
														<td scope="row">${list.getStart_date()}</td>
													</c:when>
													<c:otherwise>
														<td scope="row">${list.getStartDateName()}</td>
													</c:otherwise>
												</c:choose>

												<c:choose>
													<c:when test="${list.getEnd_date() != null}">
														<td scope="row">${list.getEnd_date()}</td>
													</c:when>

													<c:otherwise>
														<td scope="row">${list.getEndDateName()}</td>
													</c:otherwise>
												</c:choose>
												<c:if test="${roleId == 1 || roleId == 2}">
													<td scope="row"><a href="#"><button type="button"
																style="float: right; margin-right: 20px;"
																class="btn btn-warning">
																<i class="fas fa-edit" aria-hidden="true"></i>
															</button></a> <a
														href="${pageContext.request.contextPath}/api/employee/department/delete/${list.getEmployeeDepartmentId()}"><button
																type="submit" style="float: right; margin-right: 35px;"
																class="btn btn-danger">
																<i class="fas fa-times" aria-hidden="true"></i>
															</button></a></td>

												</c:if>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</c:if>

						</div>
						<!-- ACCOUNT SKILL -->
						<div class="tab-pane" id="skill">
							<a
								href="${pageContext.request.contextPath}/api/employee/skill/add/${idAccount}"
								style="float: right;" class="btn btn-outline-info" role="button">Thêm
								mới </a>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Tên nhân viên</th>
										<th scope="col">Tên kỹ năng</th>
										<th scope="col">Bắt đầu</th>
										<th scope="col">Kết thúc</th>
										<th scope="col">Trình độ</th>
										<c:if test="${roleId == 1}">
											<th scope="row">Thao tác</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${listSkillEmployee}">
										<tr>
											<td scope="row">${list.getEmployeeName()}</td>
											<td scope="row">${list.getSkillName()}</td>
											<td scope="row">${list.getSkill_start()}</td>

											<td scope="row">${list.getSkill_end()}</td>
											<td scope="row">${list.getLevelName()}</td>
											<c:if test="${roleId == 1}">
												<td><a
													href="${pageContext.request.contextPath}/api/employee/skill/updater/${list.getId()}"><button
															type="button" class="btn btn-outline-warning">Update</button></a>
													<a
													href="${pageContext.request.contextPath}/api/employee/skill/deleter/${list.getId()}"><button
															type="button"
															onclick="return confirm('Xác nhận xóa kỹ năng: ${list.getSkillName()}')"
															class="btn btn-outline-danger">Delete</button></a></td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

						<div class="tab-pane" id="leave">

							<table class="table table-bordered" id="dataTable">
								<thead>
									<c:if test="${roleId == 1 || roleId == 2}">
									</c:if>
									<tr>
										<th>Tên</th>
										<th>Loại nghỉ phép</th>
										<th>Ngày bắt đầu</th>
										<th>Ngày kết thúc</th>
										<th>Thời gian bắt đầu</th>
										<th>Thời gian kết thúc</th>
										<th>Trạng thái</th>
										<th>Người duyệt</th>
										<c:if test="${list.getAccept_status() == 0}">
											<th>Thao tác</th>
										</c:if>

									</tr>
								</thead>
								<c:forEach var="list" items="${listEmployeeLeave}">
									<tbody>
										<tr>
											<td>${list.getEmployeeName()}</td>
											<td>${list.getReasonName()}</td>
											<td>${list.getStart_date()}</td>
											<td>${list.getEnd_date()}</td>
											<td>${list.getStart_time()}</td>
											<td>${list.getEnd_time()}</td>
											<c:if test="${list.getAccept_status() == 1}">
												<td style="color: green;">${list.getAcceptStatusName()}</td>
											</c:if>

											<c:if test="${list.getAccept_status() == 0}">
												<td style="color: #FFD700;">${list.getAcceptStatusName()}</td>
											</c:if>

											<c:if test="${list.getAccept_status() == 2}">
												<td style="color: red;">${list.getAcceptStatusName()}</td>
											</c:if>
											<td>${list.getEmployee_accept()}</td>
											<c:if test="${(roleId == 1 || roleId == 2)}">
												<c:if test="${list.getAccept_status() == 0}">
													<td><a
														href="${pageContext.request.contextPath}/api/employee/leave/accept/${list.getId()}"
														class="btn btn-success" role="submit">Accept </a> <a
														href="${pageContext.request.contextPath}/api/employee/leave/cancel/${list.getId()}"
														class="btn btn-danger" role="submit">Cancel </a></td>
												</c:if>
											</c:if>
										</tr>
									</tbody>
								</c:forEach>

							</table>

						</div>

						<div class="tab-pane" id="leave">

							<table class="table table-bordered" id="dataTable">
								<thead>
									<c:if test="${roleId == 1 || roleId == 2}">
									</c:if>
									<tr>
										<th>Tên</th>
										<th>Loại nghỉ phép</th>
										<th>Ngày bắt đầu</th>
										<th>Ngày kết thúc</th>
										<th>Thời gian bắt đầu</th>
										<th>Thời gian kết thúc</th>
										<th>Trạng thái</th>
										<th>Người duyệt</th>
										<c:if test="${list.getAccept_status() == 0}">
											<th>Thao tác</th>
										</c:if>

									</tr>
								</thead>
								<c:forEach var="list" items="${listEmployeeLeave}">
									<tbody>
										<tr>
											<td>${list.getEmployeeName()}</td>
											<td>${list.getReasonName()}</td>
											<td>${list.getStart_date()}</td>
											<td>${list.getEnd_date()}</td>
											<td>${list.getStart_time()}</td>
											<td>${list.getEnd_time()}</td>
											<c:if test="${list.getAccept_status() == 1}">
												<td style="color: green;">${list.getAcceptStatusName()}</td>
											</c:if>

											<c:if test="${list.getAccept_status() == 0}">
												<td style="color: #FFD700;">${list.getAcceptStatusName()}</td>
											</c:if>

											<c:if test="${list.getAccept_status() == 2}">
												<td style="color: red;">${list.getAcceptStatusName()}</td>
											</c:if>
											<td>${list.getEmployee_accept()}</td>
											<c:if test="${(roleId == 1 || roleId == 2)}">
												<c:if test="${list.getAccept_status() == 0}">
													<td><a
														href="${pageContext.request.contextPath}/api/employee/leave/accept/${list.getId()}"
														class="btn btn-success" role="submit">Accept </a> <a
														href="${pageContext.request.contextPath}/api/employee/leave/cancel/${list.getId()}"
														class="btn btn-danger" role="submit">Cancel </a></td>
												</c:if>
											</c:if>
										</tr>
									</tbody>
								</c:forEach>

							</table>

						</div>
						<div class="tab-pane" id="rp">
							<form action="${pageContext.request.contextPath}/api/employee">
								<c:if test="${listRPEmployee.size() == 0}">
									<c:if test="${listRPEmployee.size() == 0}">
										<a href="#"><button type="button" style="float: right;"
												class="btn btn-success px-3">
												<i class="fa fa-plus" aria-hidden="true"></i>
											</button></a>
									</c:if>
								</c:if>

								<c:forEach var="list" items="${listRPEmployee}">
									<div class="card mb-3">
										<div class="card-header">
											<i class="fas fa-table"> Thông tin nhân thân</i>
										</div>
										<div class="card-body">
											<!-- Grid row -->
											<div class="form-row">
												<!-- Grid column -->
												<div class="col-md-6">
													<!-- Material input -->
													<div class="md-form form-group">
														<label><b>Họ và tên bố/ mẹ</b></label>
														<div class="form-group">
															<div class="form-label-group">
																<input type="text" class="form-control" id="1"
																	value="${list.getDad_or_mother_name()}"
																	placeholder="Họ và tên"> <label for="1">
																	Name</label>
															</div>
														</div>
													</div>
												</div>
												<!-- Grid column -->

												<!-- Grid column -->
												<div class="col-md-3">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Nghề nghiệp bố/ mẹ</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="2"
																	value="${list.getDad_or_mother_job()}"
																	placeholder="Nghề nghiệp"> <label for="2">
																	Job</label>
															</div>
														</div>
													</div>
												</div>
												<!-- Grid column -->
												<div class="col-md-3">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Số điện thoại</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="3"
																	value="${list.getDad_or_mother_phone()}"
																	placeholder="Số điện thoại"> <label for="3">
																	Phone</label>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Địa chỉ</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="4"
																	value="${list.getDad_or_mother_address()}"
																	placeholder="Địa chỉ"> <label for="4">
																	Address</label>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<!-- Material input -->
													<div class="md-form form-group">
														<label><b>Họ và tên anh/ chị/ em</b></label>
														<div class="form-group">
															<div class="form-label-group">
																<input type="text" class="form-control" id="5"
																	value="${list.getBs_name()}" placeholder="Họ và tên">
																<label for="5"> Brother or Sister name</label>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Nghề nghiệp anh/ chị/ em</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="6"
																	value="${list.getBs_phone()}" placeholder="Nghề nghiệp">
																<label for="6">Brother or Sister phone</label>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Số điện thoại</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="7"
																	value="${list.getBs_phone()}"
																	placeholder="Số điện thoại"> <label for="7">Brother
																	or Sister phone</label>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<!-- Material input -->
													<div class="md-form form-group">
														<div class="form-group">
															<label><b>Địa chỉ</b></label>
															<div class="form-label-group">
																<input type="text" class="form-control" id="8"
																	value="${list.getBs_address()}" placeholder="Địa chỉ">
																<label for="8">Brother or Sister address</label>
															</div>
														</div>
													</div>
												</div>

												<button style="margin: auto;" type="submit"
													class="btn btn-outline-success">Save</button>
											</div>
										</div>
									</div>

								</c:forEach>


							</form>
						</div>

						<div class="tab-pane" id="slr">
							<table class="table">
								<thead>
									<tr>
										<th>Mã NV</th>
										<th>Họ tên</th>
										<th>Ngày công thực tế</th>
										<th>Lương cơ bản</th>
										<th>HT ăn trưa</th>
										<th>HT điện thoại</th>
										<th>HT xăng</th>
										<th>Lương thực lãnh</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${salaryDetails}">
										<tr>
											<td>${list.getEmployeeId()}</td>
											<td>${list.getEmployeeName()}</td>
											<td>${list.getActualWorkDay()}/26</td>
											<td>${list.getBaseSalary()}</td>
											<td>${list.getLunchMoney()}</td>
											<td>${list.getPhoneMoney()}</td>
											<td>${list.getGasolineMoney()}</td>
											<td>${list.getActualSalary()}</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>

						<div class="tab-pane" id="allowance">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Tên nhân viên</th>
										<th scope="col">Tên trợ cấp</th>
										<th scope="col">Mô tả</th>
										<th scope="col">Tổng trợ cấp</th>
										<c:if test="${roleId == 1}">
											<th scope="col">Thao tác</th>
										</c:if>
										<th><a
											href="${pageContext.request.contextPath}/api/employee/allowance/add/${idAccount}"><button
													type="button" style="float: right;"
													class="btn btn-success px-3">
													<i class="fa fa-plus" aria-hidden="true"></i>
												</button></a></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${listAllownceEmployeeInfo}">
										<tr>
											<td scope="row">${list.getEmployeeName()}</td>
											<td scope="row">${list.getSatName()}</td>
											<td scope="row">${list.getSatDescription()}</td>
											<td scope="row">${list.getSaTotalSalary()}VND</td>

											<c:if test="${roleId == 1 }">
												<td><a
													href="${pageContext.request.contextPath}/api/employee/allowance/update/${list.getSaId()}"><button
															type="button" class="btn btn-outline-warning">Update</button></a>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>

			</div>
		</div>
		<!-- <div class="col-lg-4 order-lg-1 text-center">
				<img src="http://placehold.it/400"
					class="mx-auto img-fluid img-circle d-block" alt="avatar">
				<h6 class="mt-2">Upload a different photo</h6>
				<label class="custom-file"> <input type="file" id="file"
					class="custom-file-input"> <span
					class="custom-file-control">Choose file</span>
				</label>
			</div> -->
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/jquery/jquery.min.js"></script>


	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/chart.js/Chart.min.js"></script>
	<!-- 	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/datatables/jquery.dataTables.js"></script>
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/vendor/datatables/dataTables.bootstrap4.js"></script> -->

	<!-- Custom scripts for all pages -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page -->
	<!-- <script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/demo/datatables-demo.js"></script> -->
	<script
		src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/demo/chart-area-demo.js"></script>
</body>
</html>