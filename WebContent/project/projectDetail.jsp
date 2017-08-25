<?xml version="1.0" encoding="utf-8"?>
<%@page import="com.adp.entities.UserEntity"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					Project Details <small> design</small>
				</h3>
			</div>

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."><span class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="clearfix"></div>


		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Project Informations</h2>
						<div class="clearfix"></div>
					</div>

					<div class="x_content">

						<div class="col-md-9 col-sm-9 col-xs-12">

							<ul class="stats-overview">
								<li><span class="name"> Estimated budget </span> <span
									class="value text-success"> <s:property
											value="project.budget" />
								</span></li>
								<li><span class="name"> Total amount spent </span> <span
									class="value text-success"> 2000 </span></li>
								<li class="hidden-phone"><span class="name">
										Estimated project duration </span> <span class="value text-success">
										<s:property value="project.period" />
								</span></li>
							</ul>
							<br />

							<div id="mainb"></div>

							<div class="x_panel">
								<div class="x_title">
									<h2>
										Missions <small>Listing</small>
									</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<p class="text-muted font-13 m-b-30"></p>
									<table id="datatable-buttons"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Mission Name</th>
												<th>Description</th>
												<th>Budget</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="project.missions" var="mission"
												status="rowstatus">
												<tr>
													<td style="font-size: 12px"><s:property
															value="#mission.missionName" /></td>
													<td style="font-size: 12px"><s:property
															value="#mission.description" /></td>
													<td style="font-size: 12px"><s:property
															value="#mission.budget" /></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>

								</div>
							</div>




						</div>

						<!-- start project-detail sidebar -->
						<div class="col-md-3 col-sm-3 col-xs-12">

							<section class="panel">

								<div class="x_title">
									<h2>Project Description</h2>
									<div class="clearfix"></div>
								</div>
								<div class="panel-body">
									<h4 class="green">
										<s:property value="project.projectName" />
									</h4>



									<br />

									<div class="project_detail">

										<p class="title">Client Company</p>
										<p>
											<s:property value="project.client" />
										</p>
										<p class="title">Project Leader</p>
										<%
											UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
										%>
										<p>
											<%=user.getLogin()%></p>
									</div>

									<br />

								</div>

							</section>

						</div>
						<!-- end project-detail sidebar -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /page content -->