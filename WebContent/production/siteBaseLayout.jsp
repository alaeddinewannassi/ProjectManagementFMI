<?xml version="1.0" encoding="utf-8"?>
<%@page import="java.util.List"%>
<%@page import="com.adp.entities.ProjectEntity"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.adp.entities.UserEntity"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PM FMI |</title>

<link rel="stylesheet" type="text/css" href="dist/css/style.css">
	<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
	<!-- NProgress -->
<link href="vendors/nprogress/nprogress.css" rel="stylesheet">
	<!-- iCheck -->
<link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	<!-- Datatables -->
<link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">
	<!-- Dropzone.css -->
<link href="vendors/dropzone/dist/min/dropzone.min.css" rel="stylesheet">
	<!--  bootstrap select -->
<link rel="stylesheet" type="text/css"
	href="dist/css/bootstrap-select.css">

	<!-- bootstrap-progressbar -->
<link
	href="vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
	<!-- JQVMap -->
<link href="vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet" />
<!-- bootstrap-daterangepicker -->
<link href="vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

	<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">

	<!-- Header -->
	<div style="margin: 0 auto; width: 360px;">
		<tiles:insertAttribute name="header" />
	</div>
	<!-- End Header -->


	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="viewDashboard.action" class="site_title"><i
							class="fa fa-paw"></i> <span>PM FMI</span></a>
					</div>

					<div class="clearfix"></div>

					<%
						UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
					%>
					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="images/<%= user.getLogin()%>.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>

							<h2>
								<%=user.getLogin()%>
							</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">

								
								<li><a><i class="fa fa-home"></i> Dashboard <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<s:iterator value="session.projects" var="project">
										<s:url id="dashboardURL" action="viewDashboard.action">
													<s:param name="id" value="%{id}" ></s:param>
												</s:url>
											<li><s:a href="%{dashboardURL}">
													<s:property value="#project.projectName" />
												</s:a></li>
										</s:iterator>
									</ul></li>

								<li><a><i class="fa fa-desktop"></i> Projects <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><s:a action="addProject.action"> Add project </s:a></li>
										<li><s:a action="viewProjects.action"> View Projects </s:a>
										</li>
									</ul></li>
								<li><a><i class="fa fa-clone"></i> Missions <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="addMission.action">Add mission</a></li>
										<li><a href="showMissions.action">View Missions</a></li>
									</ul></li>
								<li><a><i class="fa fa-laptop"></i> Functions <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="addFunction.action">Add function</a></li>
										<li><a href="showFunctions.action">View Functions</a></li>
									</ul></li>
								<li><a><i class="fa fa-sitemap"></i>Teams <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="addTeam.action">Add Team</a></li>
										<li><a href="viewTeams.action">View Teams</a></li>
									</ul></li>
								<li><a><i class="fa fa-bug"></i> Third Parties <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="addThirdParty.action">Add Third Party </a></li>
										<li><a href="viewContributors.action">View Third
												Parties</a></li>
									</ul></li>
								<li><a><i class="fa fa-edit"></i> Time Sheets <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="timesheetUpload.action">Upload Time
												Sheet </a></li>
										<li><a href="timesheetShowReport.action">View Report
										</a></li>

									</ul></li>
									
									<li><a href="addMonth.action"><i class="fa fa-table"></i> Turnover <span
										class="fa fa-chevron-down"></span></a>
									</ul></li>

							</ul>
						</div>

					</div>
					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="logout.action"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img
								src="images/<%=user.getLogin()%>.jpg" alt=""><%=user.getLogin()%>
								<span class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="javascript:;"> Profile</a></li>
								<li><a href="javascript:;"> <span
										class="badge bg-red pull-right">50%</span> <span>Settings</span>
								</a></li>
								<li><a href="javascript:;">Help</a></li>
								<li><a href="login.action"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a></li>
							</ul></li>

						<li role="presentation" class="dropdown"><a
							href="javascript:;" class="dropdown-toggle info-number"
							data-toggle="dropdown" aria-expanded="false"> <i
								class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
						</a>
							<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
								role="menu">
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li>
									<div class="text-center">
										<a> <strong>See All Alerts</strong> <i
											class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->





			<div id="body">
				<tiles:insertAttribute name="body" />
			</div>


			<!-- Footer -->
			<div id="footer">
				<div class="shell">
					<tiles:insertAttribute name="footer" />
				</div>
			</div>
			<!-- End Footer -->

			<!-- jQuery -->
			<script src="vendors/jquery/dist/jquery.min.js"></script>
			<!-- Bootstrap -->
			<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
			<!-- FastClick -->
			<script src="vendors/fastclick/lib/fastclick.js"></script>
			<!-- NProgress -->
			<script src="vendors/nprogress/nprogress.js"></script>
			<!-- Chart.js -->
			<script src="vendors/Chart.js/dist/Chart.min.js"></script>
			<script src="vendors/Chart.js/dist/Chart.js"></script>
			<!-- gauge.js -->
			<script src="vendors/gauge.js/dist/gauge.min.js"></script>
			<!-- bootstrap-progressbar -->
			<script
				src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
			<!-- iCheck -->
			<script src="vendors/iCheck/icheck.min.js"></script>
			<!-- Skycons -->
			<script src="vendors/skycons/skycons.js"></script>
			<!-- Flot -->
			<script src="vendors/Flot/jquery.flot.js"></script>
			<script src="vendors/Flot/jquery.flot.pie.js"></script>
			<script src="vendors/Flot/jquery.flot.time.js"></script>
			<script src="vendors/Flot/jquery.flot.stack.js"></script>
			<script src="vendors/Flot/jquery.flot.resize.js"></script>
			<!-- Flot plugins -->
			<script src="vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
			<script src="vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
			<script src="vendors/flot.curvedlines/curvedLines.js"></script>
			<!-- DateJS -->
			<script src="vendors/DateJS/build/date.js"></script>
			<!-- JQVMap -->
			<script src="vendors/jqvmap/dist/jquery.vmap.js"></script>
			<script src="vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
			<script src="vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
			<!-- bootstrap-daterangepicker -->
			<script src="vendors/moment/min/moment.min.js"></script>
			<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

			<!-- Custom Theme Scripts -->
			<script src="build/js/custom.min.js"></script>

			<!--  Bootstrap Select Scripts -->
			<script type="text/javascript" src="dist/js/bootstrap-select.js"></script>

			<script type="text/javascript" src="dist/js/script.js"></script>

			<!-- Datatables -->
			<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
			<script
				src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
			<script
				src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
			<script
				src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
			<script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
			<script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
			<script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
			<script
				src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
			<script
				src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
			<script
				src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
			<script
				src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
			<script
				src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
			<script src="vendors/jszip/dist/jszip.min.js"></script>
			<script src="vendors/pdfmake/build/pdfmake.min.js"></script>
			<script src="vendors/pdfmake/build/vfs_fonts.js"></script>

			<!-- Dropzone.js -->
			<script src="vendors/dropzone/dist/min/dropzone.min.js"></script>
</body>
</html>
