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
						<h2>Turnover Details</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate=""
							method="post">
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
										Turnover Per mission <small>Listing</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<s:iterator value="project.missions" var="mission">

									<div class="x_content">
										<p class="text-muted font-13 m-b-30"></p>
										<table id="datatable-buttons"
											class="table table-striped table-bordered">

											<thead>
												<tr>
													<th colspan="3"><s:property
															value="#mission.missionName" /></th>
													<th colspan="2">Actuals</th>
													<th>Project Progress</th>
													<th colspan="2">Monthly CA</th>
													<th>Real RTD</th>

												</tr>
											</thead>


											<tbody>

												<tr>
													<th>Reference Date</th>
													<th>PM REV WKL</th>
													<th>PM REV TO</th>

													<th>Monthly</th>
													<th>Cumulated Total</th>

													<th>Total</th>

													<th>Monthly</th>
													<th>Cumulated Total</th>

												</tr>


												<s:iterator value="#mission.turnover.monthlyTurnovers"
													var="monthlyturnover">
													<tr>

														<td><s:property
																value="#monthlyturnover.referenceDate" /></td>

														<td><s:property
																value="#monthlyturnover.turnover.revisedWorkload" /></td>
														<td><s:property
																value="#monthlyturnover.turnover.revisedBudgetAmount" /></td>
														<td><s:property value="#monthlyturnover.actual" /></td>
														<td><s:property value="#monthlyturnover.turnover.cumulatedActuals" /></td>
														<td><s:property value="#monthlyturnover.progress" /></td>
														<td><s:property
																value="#monthlyturnover.turnoverAmount" /></td>
														<td><s:property
																value="#monthlyturnover.turnover.turnoverAmount" /></td>
														<td><s:property value="#monthlyturnover.realRTD" /></td>

													</tr>
												</s:iterator>
											</tbody>
										</table>

									</div>

								</s:iterator>
							</div>
						</div>

						<div style="float: right; margin-right: 25px;" >
							<form action="addMonth.action">

								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
										<button type="submit" class="btn btn-success">Add
											Month</button>
									</div>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- /page content -->
