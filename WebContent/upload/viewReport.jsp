<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left"></div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Report</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate=""
							method="post" >
							<p style="color: red;">
								<s:if test="hasActionErrors()">
									<div id="loginMsg"
										style="padding-left: 10px; padding-right: 10px; color: red;">
										<s:iterator value="actionErrors">
											<p class="msg error">
												<s:property escape="false" />
											</p>
										</s:iterator>
									</div>
								</s:if>
								<s:elseif test="hasActionMessages()">
									<div
										style="padding-left: 10px; padding-right: 10px; color: green;">
										<s:iterator value="actionMessages">
											<p class="msg info" style="color: green;">
												<s:property escape="false" />
											</p>
										</s:iterator>
									</div>
								</s:elseif>
							</p>
						</form>



						<div class="col-md-12 col-sm-12 col-xs-12">
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
												<th style="width: 20%">ThirdParty Name</th>
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

														<td width="15%"><s:property
																value="#inputLine.contributorName" /></td>
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



						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Input errors <small>Listing</small>
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
												<th>Description</th>
												<th>Type</th>
												<th>Possible Solution</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="instances" var="instance"
												status="rowstatus">
												<s:iterator value="#instance.inputErrors" var="inputError"
													status="rowstatus">
													<tr>
														<td style="font-size: 12px"><s:property
																value="#inputError.errorDescription" /></td>
														<td style="font-size: 12px"><s:property
																value="#inputError.errorType" /></td>
														<td style="font-size: 12px"><s:property
																value="#inputError.possibleSolution" /></td>
													</tr>
												</s:iterator>
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


					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- /page content -->
