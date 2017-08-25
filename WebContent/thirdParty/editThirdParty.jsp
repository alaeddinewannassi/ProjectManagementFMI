<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- page content -->
<div class="right_col" role="main">
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Edit a Contributor</h2>


					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"><i
								class="fa fa-wrench"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Settings 1</a></li>
								<li><a href="#">Settings 2</a></li>
							</ul></li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br>
					<form id="demo-form2" data-parsley-validate=""
						class="form-horizontal form-label-left" novalidate=""
						method="post" action="editThirdParty.action">


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
							<div class="col-md-6 col-sm-6 col-xs-12">

								<input type="hidden" name="id"
									value="<s:property value="thirdParty.id"/>" required="required"
									class="form-control col-md-7 col-xs-12" hidden>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="firstName">First Name :<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">

								<input type="text" name="firstName"
									value="<s:property value="thirdParty.firstName" />"
									required="required" class="form-control col-md-7 col-xs-12">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="firstName">Email :<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">

								<input type="text" name="email"
									value="<s:property value="thirdParty.email" />"
									required="required" class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="form-group">
							<label for="budget"
								class="control-label col-md-3 col-sm-3 col-xs-12"> Last
								Name:<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="lastName" required="required"
									value="<s:property value="thirdParty.lastName" />"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>


						<div class="form-group" style="margin-left: 180px">
							<s:label for="interestSelect" value="Interests :" />
							&nbsp; &nbsp;
							<s:select id="interestSelect"
								cssStyle="padding:10px ; margin-left:100px ; margin-top: -120px;"
								cssClass="selectpicker" list="interests" listKey="interestName"
								listValue="interestName" headerKey="0"
								headerValue="Select interests" multiple="true"
								value="oldInterests" label="Select interests"
								name="selectedInterests" />
							</br> </br>
						</div>
						<div class="form-group">
							<label for="budget"
								class="control-label col-md-3 col-sm-3 col-xs-12">Job
								Title :<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="jobTitle" required="required"
									value="<s:property value="thirdParty.jobTitle" />"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>
						<LABEL for="teamSelect"
							class="control-label col-md-3 col-sm-3 col-xs-12">Select
							a team :</LABEL> </br>
						<s:select id="teamSelect"
							cssStyle="padding:10px ; margin-top: -120px;" list="teams"
							listKey="teamName" listValue="teamName" headerKey="0"
							headerValue="Select a team" label="Select a team"
							value="thirdParty.team.teamName" name="selectedTeam" />
						<br /> <br />
						<div class="form-group">
							<label for="budget"
								class="control-label col-md-3 col-sm-3 col-xs-12">Adresse
								:<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="adresse" required="required"
									value="<s:property value="thirdParty.adresse" />"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>

						<div class="form-group">
							<label for="budget"
								class="control-label col-md-3 col-sm-3 col-xs-12">Phone
								Number :<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" name="phone" required="required"
									value="<s:property value="thirdParty.phone" />"
									class="form-control col-md-7 col-xs-12">
							</div>
						</div>


						<div class="ln_solid"></div>
						<div class="form-group">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
								<button class="btn btn-primary" type="reset">Reset</button>
								<button type="submit" class="btn btn-success">Submit</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>



