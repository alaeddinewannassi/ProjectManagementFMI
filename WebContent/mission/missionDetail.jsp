<?xml version="1.0" encoding="utf-8"?>
<%@page import="com.adp.entities.UserEntity"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
				<h3>
					Mission Detail <small> design</small>
				</h3>
			</div>
			<SCRIPT type="text/javascript">
				function showDiv() {
					//	document.getElementById('CAresult').style.display = "block";
					// document.getElementById('chiffreAffaire').style.display = "none";

				}
			</SCRIPT>
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
						<h2>Mission informations</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br>
						<s:form id="demo-form2" cssClass="form-horizontal form-label-left"
							method="post" action="saveMission.action">


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
											<p class="msg info" style="color: blue;">
												<s:property escape="false" />
											</p>
										</s:iterator>
									</div>
								</s:elseif>
							</p>

						</s:form>
					</div>
					<div class="clearfix"></div>
					<div class="x_content">

						<div class="col-md-9 col-sm-9 col-xs-12">

							<ul class="stats-overview">
								<li><span class="name"> Revised budget </span> <span
									class="value text-success"> <s:property
											value="mission.turnover.revisedBudgetAmount" />
								</span></li>
								<li><span class="name"> Revised Workload </span> <span
									class="value text-success"> <s:property
											value="mission.turnover.revisedWorkload" />
								</span></li>

								<li><span class="name"> Total cumulated actuals </span> <span
									class="value text-success"> <s:property
											value="mission.totalCumulatedActuals" />
								</span></li>

							</ul>

							<div class="clearfix"></div>
					

							<div id="mainb"></div>

							<div class="x_panel">
								<div class="x_title">
									<h2>
										Functions <small>Listing</small>
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
												<th>Function Name</th>
												<th>Description</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="mission.functions" var="function"
												status="rowstatus">
												<tr>
													<td style="font-size: 12px"><s:property
															value="#function.functionName" /></td>
													<td style="font-size: 12px"><s:property
															value="#function.description" /></td>
													<td style="font-size: 12px"><s:property
															value="#function.status" /></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>

								</div>
							</div>




						</div>

						<!-- start Mission-detail sidebar -->
						<div class="col-md-3 col-sm-3 col-xs-12">

							<section class="panel">

								<div class="x_title">
									<h2>Mission Description</h2>
									<div class="clearfix"></div>
								</div>
								<div class="panel-body">
									<h4 class="green" style="font-size: 12px">
										<s:property value="mission.MissionName" />
									</h4>

									<br />

									<div class="project_detail">

										<p class="title">Mission Details</p>
										<p>
											<s:property value="mission.description" />
									</div>

									<br />

								</div>

							</section>

						</div>
						<!-- end Mission-detail sidebar -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- /page content -->