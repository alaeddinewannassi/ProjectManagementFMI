<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Add a Mission</h2>
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
										<p class="msg info" style="color: green;">
											<s:property escape="false" />
										</p>
									</s:iterator>
								</div>
							</s:elseif>
						</p>


						<s:select
							cssStyle="padding:10px ; margin-left: 180px; margin-top: -120px;"
							name="selectedProject" list="session.projects" listKey="projectName"
							listValue="projectName" headerKey="0"
							headerValue="Select a project" label="Select a project" />
						</br>


						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="MissionName"> Mission Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="missionName" required="required"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="description"> Description <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="description" required="required"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="workload"> Workload (Per days) <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input id="workload" type="text" name="workload" required="required"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="form-group">
							<label for="budget"
								class="control-label col-md-3 col-sm-3 col-xs-12">Budget 
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="budget" required="required"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="clearfix"></div>
						<div class="clearfix"></div>
						</br>
						</br>

						<div class="ln_solid"></div>

						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button class="btn btn-primary" type="button">Cancel</button>
								<button class="btn btn-primary" type="reset">Reset</button>
								<button type="submit" class="btn btn-success">Submit</button>
							</div>
						</div>

					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>



