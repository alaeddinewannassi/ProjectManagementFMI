<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>User Profile</h3>
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
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							User Report <small>Activity report</small>
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="col-md-3 col-sm-3 col-xs-12 profile_left">
							<div class="profile_img">
								<div id="crop-avatar">
									<!-- Current avatar -->
									<img class="img-responsive avatar-view"
										src="images/<s:property value="contributor.fullName"/>.jpg"
										alt="Avatar" title="Change the avatar">
								</div>
							</div>
							<h3>
								<s:property value="contributor.firstName" />
								<s:property value="contributor.lastName" />
							</h3>

							<ul class="list-unstyled user_data">
								<li><i class="fa fa-map-marker user-profile-icon"></i> <s:property
										value="contributor.adresse" /></li>

								<li><i class="fa fa-briefcase user-profile-icon"></i> <s:property
										value="contributor.jobTitle" /></li>

								<li class="m-top-xs"><i
									class="fa fa-external-link user-profile-icon"></i> <a
									href="http://www.vermeg.com" target="_blank">www.vermeg.com</a>
								</li>
							</ul>
							<s:url id="editURL" action="modifyThirdParty.action">
								<s:param name="id" value="%{contributor.id}"></s:param>
							</s:url>

							<s:url id="historyURL" action="historyThirdParty.action">
								<s:param name="thirdPartyName" value="%{contributor.fullName}"></s:param>
							</s:url>

							&nbsp;
							<s:a theme="simple" href="%{editURL}" cssClass="btn btn-success">Edit Profile</s:a>
							<br /> &nbsp;
							<BUTTON class="btn btn-primary">
								<s:a cssStyle="color: white" theme="simple" href="%{historyURL}">Activity History</s:a>
							</BUTTON>


							<!-- start skills -->
							<h4>Skills</h4>
							<ul class="list-unstyled user_data">
								<li>
									<p>Web Applications</p>
									<div class="progress progress_sm">
										<div class="progress-bar bg-green" role="progressbar"
											data-transitiongoal="50"></div>
									</div>
								</li>
								<li>
									<p>Website Design</p>
									<div class="progress progress_sm">
										<div class="progress-bar bg-green" role="progressbar"
											data-transitiongoal="70"></div>
									</div>
								</li>
								<li>
									<p>Automation & Testing</p>
									<div class="progress progress_sm">
										<div class="progress-bar bg-green" role="progressbar"
											data-transitiongoal="30"></div>
									</div>
								</li>
								<li>
									<p>UI / UX</p>
									<div class="progress progress_sm">
										<div class="progress-bar bg-green" role="progressbar"
											data-transitiongoal="50"></div>
									</div>
								</li>
							</ul>
							<!-- end of skills -->

						</div>
						<div class="col-md-9 col-sm-9 col-xs-12">

							<div class="col-md-6">
								<h2>User Activity Report</h2>
							</div>
							<div>
								<div class="x_panel">
									<div class="x_title">
										<h2>
											Timesheet <small>Listing</small>
										</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<p class="text-muted font-13 m-b-30"></p>
										<table id="datatable-buttons"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>Mission Name</th>
													<th>Function Name</th>
													<th>Comment</th>
													<th>Date</th>
													<th>Hours</th>

												</tr>
											</thead>


											<tbody>
												<s:iterator value="instances" var="instance"
													status="rowstatus">
													<s:iterator value="#instance.inputLines" var="inputLine"
														status="rowstatus">
														<tr>

															<td style="font-size: 11px"><s:property
																	value="#inputLine.mission.missionName" /></td>
															<td width="200px" style="font-size: 11px"><s:property
																	value="#inputLine.function.functionName" /></td>
															<td width="500px" style="font-size: 11px"><s:property
																	value="#inputLine.comment" /></td>
															<td width="150px" style="font-size: 11px"><s:date
																	name="date" format="dd/MMM/yyyy" /></td>

															<td style="font-size: 11px"><s:property
																	value="#inputLine.hours" /></td>


														</tr>
													</s:iterator>
												</s:iterator>
											</tbody>
										</table>
									</div>
								</div>
							</div>

							<div class="clearfix"></div>
							<div>
								<div class="x_panel">
									<div class="x_title">
										<h2>
											Errors <small>Listing</small>
										</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<p class="text-muted font-13 m-b-30"></p>
										<table id="datatable-buttons"
											class="table table-striped table-bordered">
											<thead>
												<tr>
													<th>Month</th>
													<th>Errors number</th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="instances" var="instance"
													status="rowstatus">
													<tr>
														<td style="font-size: 12px"><s:property
																value="#instance.timesheet.month" /></td>
														<td style="font-size: 12px"><s:property
																value="#instance.timesheet.errorsNumber" /></td>
													</tr>
												</s:iterator>
											</tbody>
										</table>
										<form action="sendErrors.action" method="post">

											<input class="btn btn-primary" style="float: right"
												type="submit" value="Send Email" />
										</form>
									</div>
								</div>
							</div>

							<!-- start of user-activity-graph -->
							<div id="graph_bar" style="width: 100%; height: 280px;"></div>
							<!-- end of user-activity-graph -->


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>