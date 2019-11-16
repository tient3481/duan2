<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>XTEL</title>

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
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
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
						href="${pageContext.request.contextPath}/api/employee/update/${idAccount}">Account
						info: ${username}</a> <a class="dropdown-item"
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
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-home"></i> <span>Dashboard</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>Metadata</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Danh mục</h6>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/account/login">Tài
						khoản</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/login">Nhóm kỹ
						năng</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/login">Kỹ năng</a>
					<a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/login">Phòng
						ban</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/login">Danh mục
						nghỉ phép</a>
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
${pageContext.request.contextPath}/api/employee/checkin">Thông
						tin cá nhân</a> <a class="dropdown-item"
						href="
${pageContext.request.contextPath}/api/employee/checkin">Thông
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
${pageContext.request.contextPath}/api/login">Danh
						sách bảng lương</a>
					<div class="dropdown-divider"></div>

					<!-- <h6 class="dropdown-header">Other Pages:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a> <a
						class="dropdown-item" href="blank.html">Blank Page</a> -->
				</div></li>
			<!-- 		<li class="nav-item"><a class="nav-link" href="tables.html">
					<i class="fas fa-fw fa-table"></i> <span>Thông tin chung</span>
			</a></li> -->
		</ul>
		<!--slide bar  -->

		<!-- Content -->
		<div class="container">
			<div class="row my-4">
				<div style="width: 100%">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a href="" data-target="#profile"
							data-toggle="tab" class="nav-link active">Thông tin cơ bản</a></li>

						<li class="nav-item"><a href="" data-target="#department"
							data-toggle="tab" class="nav-link">Thông tin phòng ban</a></li>

						<li class="nav-item"><a href="" data-target="#skill"
							data-toggle="tab" class="nav-link">Thông tin kỹ năng</a></li>

						<li class="nav-item"><a href="" data-target="#leave"
							data-toggle="tab" class="nav-link">Thông tin nghỉ phép</a></li>

						<li class="nav-item"><a href="" data-target="#family"
							data-toggle="tab" class="nav-link">Thông tin nhân thân</a></li>
					</ul>
					<div class="tab-content py-4">
						<div class="tab-pane active" id="profile">
							<form action="${pageContext.request.contextPath}/api/employee">

								<c:forEach var="infoEmployee" items="${infoEmployee}">
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">User
											ID</label>
										<div class="col-lg-9">
											<input name="id" class="form-control" type="text"
												value="${infoEmployee.getId()}" readonly="readonly">
										</div>
									</div>

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
											<label class="col-lg-9" for="male">Male</label> <input
												type="radio" name="gender" value="0" checked> <label
												class="col-lg-9" for="female">Female</label> <input
												type="radio" name="gender" value="1">
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
										<label class="col-lg-3 col-form-label form-control-label">Base
											salary</label>
										<div class="col-lg-9">
											<input name="base_salary" class="form-control" type="text"
												value="${infoEmployee.getBase_salary()}">
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
										<label class="col-lg-3 col-form-label form-control-label"></label>
										<div class="col-lg-9">
											<input type="submit" name="updateAccount"
												class="btn btn-primary" value="Save Changes">
										</div>
									</div>

								</c:forEach>
							</form>
						</div>

						<!-- ACCOUNT DEPARTMENT INFO -->
						<div class="tab-pane" id="department">

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
									</tr>
								</thead>
								<tbody>
									<tr>
										<c:forEach var="list" items="${listEmployeeDepartment}">
											<td scope="row">${list.getEmployeeName()}</td>
											<td scope="row">${list.getEmployeeTypeName()}</td>
											<td scope="row">${list.getDepartmentName()}</td>
											<td scope="row">${list.getDepartmentPhone()}</td>
											<td scope="row">${list.getDepartmentLocation()}</td>
											<td scope="row">${list.getPositionName()}</td>
											<td scope="row">${list.getStart_date()}</td>
											<td scope="row">${list.getEnd_date()}</td>
										</c:forEach>
									</tr>
								</tbody>
							</table>

						</div>
						<!-- ACCOUNT SKILL -->
						<div class="tab-pane" id="skill">

							<table class="table">
								<thead>
									<tr>
										<th scope="col">Employee name</th>
										<th scope="col">Skill name</th>
										<th scope="col">Skill main</th>
										<th scope="col">Skill start</th>
										<th scope="col">Skill end</th>
										<th scope="col">Level name</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${listSkillEmployee}">
										<tr>
											<td scope="row">${list.getEmployeeName()}</td>
											<td scope="row">${list.getSkillName()}</td>
											<td scope="row">${list.getSkill_main()}</td>
											<td scope="row">${list.getSkill_start()}</td>
											<td scope="row">${list.getSkill_end()}</td>
											<td scope="row">${list.getLevelName()}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

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
	</div>

	<!--LOG OUT -->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
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