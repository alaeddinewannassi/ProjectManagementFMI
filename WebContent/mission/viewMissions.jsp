<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("êtes-vous sûr de vouloir supprimer? ");
		if (conf == true)
			document.location = "removeMission.action?id=" + id;
	}
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					Missions <small>Listing design</small>
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
						<h2>Missions</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate=""
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
						</form>

						<form action="" method="post">
							<!-- start mission list -->
							<table class="table table-striped projects">
								<thead>
									<tr>
										<th style="width: 1%">#</th>
										<th style="width: 20%">Mission Name</th>
										<th>Project Name</th>
										<th>Budget</th>
										<th>Description</th>
										<th>Mission Progress</th>

										<th style="width: 20%">#Edit</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="missions" var="mission" status="rowstatus">
										<tr>
											<td><s:property value="#mission.id" /></td>
											<td><a><s:property value="#mission.missionName" /></a></td>
											<td><s:property value="#mission.project.projectName" /></td>

											<td><s:property value="#mission.budget" /></td>
											<td><s:property value="#mission.description" /></td>

											<td class="project_progress">
												<div class="progress progress_sm">
													<div class="progress-bar bg-green" role="progressbar"
														data-transitiongoal="<s:property value="#mission.status"/>"></div>
												</div> <s:property value="#mission.status" /> <small>
													Complete</small>
											</td>


											<td>
												<!--  VIEW MISSION --> <s:url id="viewURL"
													action="detailMission.action">
													<s:param name="id" value="%{id}"></s:param>
												</s:url> <s:a href="%{viewURL}" cssClass="btn btn-primary btn-xs">
													<i class="fa fa-folder"></i> View </s:a> <!--  EDIT MISSION --> <s:url
													id="editURL" action="modifyMission.action">
													<s:param name="id" value="%{id}"></s:param>

												</s:url> <s:a href="%{editURL}" cssClass="btn btn-info btn-xs">
													<i class="fa fa-pencil"></i> Edit </s:a> <!--  REMOVE MISSION -->
												<s:url id="removeURL" action="removeMission.action">
													<s:param name="id" value="%{id}"></s:param>
												</s:url> <s:a href="javascript:confirmation(%{id})"
													cssClass="btn btn-danger btn-xs">
													<i class="fa fa-trash-o"></i> Delete </s:a>

											</td>

										</tr>
									</s:iterator>


								</tbody>
							</table>
						</form>
						<!-- end mission list -->

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->