<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
<body class="bg-dark">
	<a>${message}</a>
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Register an Account</div>
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/api/account">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<div class="form-label-group">
									<input type="text" id="firstName" class="form-control"
										name="username" placeholder="First name" required="required"
										autofocus="autofocus"> <label for="firstName">User
										name</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-label-group">
									<input type="password" id="inputPassword" class="form-control"
										name="password" placeholder="Password" required="required">
									<label for="inputPassword">Password</label>
								</div>
							</div>
						</div>
					</div>
					<div class="form-label-group">
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="sel1">Employee:</label> <select name="employee_id"
										class="form-control" id="sel1">
										<c:forEach items="${employee}" var="employee">
											<option value="${employee.getEmployeeId()}">${employee.getEmployeeName()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-6">
									<label for="sel1">Role:</label> <select class="form-control"
										name="role_id" id="sel1">
										<c:forEach items="${role}" var="role">
											<option value="${role.getRoleId()}">
												${role.getRoleName()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div>
					<button type="submit" name="createAccount" class="btn btn-primary">Register</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.html">Login Page</a> <a
						class="d-block small" href="forgot-password.html">Forgot
						Password?</a>
				</div>
			</div>
		</div>
	</div>

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