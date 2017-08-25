<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- page content -->

<div class="right_col" role="main">
	<!-- top tiles -->
	<div class="row tile_count">

		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-clock-o"></i> Project
				Name </span>

			<div
				style="color: #1ABB9C; font-size: 15px; padding-top: 10px; Font-Weight: Bold;">
				<s:property value="project.projectName" />
			</div>
		</div>

		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total
				Turnover Amount </span>
			<div class="count">
				<s:property value="project.turnoverAmount" />
			</div>
			<span class="count_bottom"><i class="green">4% </i> From last
				Month</span>
		</div>

		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total Teams</span>
			<div class="count green">
				<s:property value="project.teams.size" />
			</div>
			<span class="count_bottom"><i class="green"><i
					class="fa fa-sort-asc"></i>34% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Total
				Contributors</span>
			<div class="count">
				<s:property value="project.contributorsNumber" />
			</div>
			<span class="count_bottom"><i class="red"><i
					class="fa fa-sort-desc"></i>12% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Creation
				Date</span>
			<div class="count green" style="font-size: 98%">
				<s:property value="project.creationDate" />
			</div>
			<span class="count_bottom"><i class="green"><i
					class="fa fa-sort-asc"></i>34% </i> From last Week</span>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
			<span class="count_top"><i class="fa fa-user"></i> Project
				Client</span>
			<div
				style="color: #1ABB9C; font-size: 15px; padding-top: 10px; Font-Weight: Bold;">
				<s:property value="project.client" />
			</div>

		</div>
	</div>
	<!-- /top tiles -->
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="dashboard_graph">

				<div class="row x_title">
					<div class="col-md-6">
						<h3>
							Turnover Per Month <small>Graph </small>
						</h3>
					</div>
					<div class="col-md-6">
						<div id="reportrange" class="pull-right"
							style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
							<i class="glyphicon glyphicon-calendar fa fa-calendar"></i> <span>December
								30, 2014 - January 28, 2015</span> <b class="caret"></b>
						</div>
					</div>
				</div>

				<div class="col-md-9 col-sm-9 col-xs-12">
					<div id="chart_plot_01" class="demo-placeholder"></div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-12 bg-white">
					<div class="x_title">
						<h2>Top Missions Performance</h2>
						<div class="clearfix"></div>
					</div>

					<div class="col-md-12 col-sm-12 col-xs-6">

						<s:iterator value="project.missions" var="mission">
							<div>
								<p>
									<s:property  value="#mission.missionName" />
								</p>
								<div class="">
									<div class="progress progress_sm" style="width: 76%;">
										<div class="progress-bar bg-green" role="progressbar"
											data-transitiongoal="<s:property value="#mission.status"/>"></div>
									</div>
								</div>
							</div>
						</s:iterator>

					</div>

				</div>

				<div class="clearfix"></div>
			</div>
		</div>

	</div>
	<br />

	<div class="row">


		<div class="col-md-6 col-sm-6 col-xs-12">
			<div class="x_panel tile fixed_height_320 overflow_hidden">
				<div class="x_title">

					<s:url id="calculateURL" action="calculTurnoverAmount.action">
						<s:param name="id">
							<s:property value="project.id" />
						</s:param>
					</s:url>

					<h2>
						<s:a href="%{calculateURL}">
							<s:property value="project.projectName" />
						</s:a>
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<table class="" style="width: 100%">
						<tr>
							<th style="width: 37%;">
								<p></p>
							</th>
							<th>
								<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
									<p class="">Mission</p>
								</div>
								<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
									<p style="float: right;">Progress</p>
								</div>
							</th>
						</tr>
						<tr>
							<td>
								<canvas class="canvasDoughnut" height="140" width="140"
									style="margin: 15px 10px 10px 0"></canvas>
							</td>
							<td>
								<table class="tile_info">
									<s:iterator value="project.missions" var="mission">
										<tr>
											<td>
												<p style="font-size: 10px;">
													<i class="fa fa-square blue"></i>

													<s:property value="#mission.missionName" />
												</p>
											</td>
											<td><s:property value="#mission.status" /></td>
										</tr>
									</s:iterator>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

	</div>


	
</div>


