<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Calculate Turnover Filters :</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br> <!-- JavaScript Plugins -->
					<script>
						function showDiv() {
							 document.getElementById('show').style.display='block';
						}

						function getProjects() {

							var selectedMonth = $('#month').val();

							$.getJSON('doAddMonth.action', {
								'selectedMonth' : selectedMonth
							}, function(data) {
								//alert(data.projects);
								var projectList = (data.projectList);

								var options = $("#project");
								options.find('option').remove().end();
								options.append($("<option/>").val("0").text(
										"Select a project"));
								$.each(projectList, function() {
									options.append($("<option/>").val(this)
											.text(this));
								});
							});
						}

						function getMissions() {

							var selectedProject = $('#project').val();

							$.getJSON('doAddMonth.action', {
								'selectedProject' : selectedProject
							}, function(data) {
								//alert(data.missions);
								var missionList = (data.missionList);

								var options = $("#mission");
								options.find('option').remove().end();
								options.append($("<option/>").val("0").text(
										"Select a mission"));
								$.each(missionList, function() {
									options.append($("<option/>").val(this)
											.text(this));
								});
							});
						}
					</script>

					<!-- jQuery-UI Dependent Scripts -->






					<s:form id="demo-form2" cssClass="form-horizontal form-label-left"
						method="post" action="calculateTurnover.action">


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

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="selectedMonth"> Month :</label>
							<s:select
								cssStyle="padding:10px ; margin-left: 220px; margin-top: -350px;"
								onchange="getProjects()" id="month" name="selectedMonth"
								list="months" headerKey="0" headerValue="Select a month"
								label="Select a month" />
						</div>
						</br>


						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="selectedMonth">Project Name :</label>
							<s:select
								cssStyle="padding:10px ; margin-left: 220px; margin-top: -300px;"
								id="project" onchange="getMissions()" name="selectedProject"
								list="session.projects" listKey="projectName"
								listValue="projectName" headerKey="0"
								headerValue="Select a project" label="Select a project" />
						</div>
						</br>


						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="selectedMonth">Mission Name :</label>
							<s:select id="mission"
								cssStyle="padding:10px ; margin-left: 220px; margin-top: -250px;"
								name="selectedMission" list="missions" listKey="missionName"
								listValue="missionName" headerKey="0"
								headerValue="Select a mission" label="Select a mission" />
						</div>



						</br>
						</br>
						<div class="inline form-group" style="margin-left: 180px" >
							
							
							<label>Calcul Type :</label> 
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							<label class="radio-inline">
								<input type="radio" name="calculType" value="automatic" checked>
									Automatic 
							</label> <label class="radio-inline"> <input type="radio"
								name="calculType" id="show" value="manual" onchange="showDiv()">Manual
							</label>
							</div>
						</div>


						
						<div id="manual" class="form-group" >
										<label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="RTD"> RTD for month <s:property
												value="currentMonth" /> : <span class="required">*</span>
										</label>
										<div class="col-md-3 col-sm-3 col-xs-6">
											<input class="form-control col-md-7 col-xs-12"
												value="<s:property value="mission.latestRTD"/>"
												name="newRTD" type="text" required="required" />
										</div>
				<br><br>
						<div class="ln_solid"></div>

						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button class="btn btn-primary" type="reset">Reset</button>
								<button type="submit" class="btn btn-success">Calculate</button>
							</div>
						</div>

					</s:form>





				</div>
			</div>
		</div>
	</div>
</div>



