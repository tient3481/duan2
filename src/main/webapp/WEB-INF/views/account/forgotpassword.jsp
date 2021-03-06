<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>ANKN Team</title>

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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Reset Password</div>
			<div class="card-body">
				<div class="text-center mb-4">
					<h4>Forgot your password?</h4>
					<p>Enter your email address and we will send you instructions
						on how to reset your password.</p>
				</div>
				<form action="${pageContext.request.contextPath}/api/account"
					method="get">
					<div class="form-group">
						<div class="form-label-group">
							<input type="email" name="emailReset" id="inputEmail"
								class="form-control" placeholder="Enter email address"
								required="required" autofocus="autofocus"> <label
								for="inputEmail">Enter email address</label>
						</div>
					</div>


					<button type="submit" name="submitEmail"
						class="btn btn-primary btn-block">Send</button>

					<c:if test="${not empty message}">
						<div class="alert alert-${alerted}" role="alert"
							style="margin-top: 10px;">
							Thông báo! <a href="#" class="alert-link"> ${message} </a>
						</div>
					</c:if>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="register">Register an
						Account</a> <a class="d-block small" href="login">Login Page</a>
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