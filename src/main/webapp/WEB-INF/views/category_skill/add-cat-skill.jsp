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

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Overview</li>
				</ol>

				<!-- Icon Cards-->
				<div class="row">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">26 New Messages!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-list"></i>
								</div>
								<div class="mr-5">11 New Tasks!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">123 New Orders!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-life-ring"></i>
								</div>
								<div class="mr-5">13 New Tickets!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</div>

				<!-- Area Chart Example-->
				<%-- 	<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-area"></i> Area Chart Example
					</div>
					<div class="card-body">
						<canvas id="myAreaChart" width="100%" height="30"></canvas>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div> --%>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"> Thêm mới nhóm kỹ năng</i>
					</div>
					<div class="card-body">
						<form
							action="${pageContext.request.contextPath}/api/category-skill">
							<div class="form-row">
								<!-- Grid column -->
								<div class="col-md-12">
									<!-- Material input -->
									<div class="md-form form-group">
										<label><b>Tên nhóm kỹ năng</b></label>
										<div class="form-group">
											<div class="form-label-group">
												<input type="text" class="form-control" id="1" name="name"
													placeholder="Tên kỹ năng"> <label for="1">Category
													Skill Name</label>
											</div>
											`
										</div>
									</div>
								</div>
								<!-- Grid column -->

								<!-- Grid column -->
								<div class="col">
									<!-- Material input -->
									<div class="md-form form-group">
										<div class="form-group">
											<label><b>Mô tả nhóm kỹ năng</b></label>
											<div class="form-label-group">
												<textarea class="form-control" rows="10" id="2"
													name="description"></textarea>
											</div>
										</div>
									</div>
								</div>
							</div>
							<button type="submit" name="addSkillCat"
								class="btn btn-outline-warning">Save</button>
							<br>
							<c:if test="${not empty message}">
								<div class="alert alert-${alerted}" role="alert">
									Thông báo! <a href="#" class="alert-link"> ${message} </a>
								</div>
							</c:if>
						</form>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->

		<!-- Sticky Footer -->
		<footer class="sticky-footer">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright © Your Website 2019</span>
				</div>
			</div>

		</footer>

	</div>
	<!-- /.content-wrapper -->

	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
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
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
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