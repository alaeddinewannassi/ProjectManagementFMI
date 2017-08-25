<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
	function confirmation(id) {
		var conf = confirm("êtes-vous sûr de vouloir supprimer? ");
		if (conf == true)
			document.location = "removeTeam.action?id=" + id;
	}
</script>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					Teams <small>Listing design</small>
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
						<h2>Projects</h2>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<form id="demo-form2" data-parsley-validate=""
							class="form-horizontal form-label-left" novalidate=""
							method="post" action="saveProject.action">
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
							<!-- start project list -->
							<table class="table table-striped projects">
								<thead>
									<tr>
										<th style="width: 1%">#</th>
										<th style="width: 20%">Team Name</th>
										<th>Team Members</th>
										<th>Project Name</th>
										<th style="width: 20%">#Edit</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="teams" var="team" status="rowstatus">
										<tr>
											<td><s:property value="#team.id" /></td>
											<td><a><s:property value="#team.teamName" /></a></td>
											<td>
												<ul class="list-inline">
													<s:iterator value="#team.employees" var="thirdParty">
														<li><img
															src="images/<s:property value="#thirdParty.fullName"/>.jpg"
															class="avatar" alt="Avatar"><br /> <small>
																<s:property value="#thirdParty.lastName" />
														</small></li>
													</s:iterator>
												</ul>
											</td>
											<td><s:property value="#team.project.projectName" /></td>
											<td>
												<!--  VIEW TEAM --> <s:url id="viewURL"
													action="detailTeam.action">
													<s:param name="id" value="%{id}"></s:param>
												</s:url> <s:a href="%{viewURL}" cssClass="btn btn-primary btn-xs">
													<i class="fa fa-folder"></i> View </s:a> <!--  EDIT TEAM --> <s:url
													id="editURL" action="modifyTeam.action">
													<s:param name="id" value="%{id}"></s:param>
												</s:url> <s:a href="%{editURL}" cssClass="btn btn-info btn-xs">
													<i class="fa fa-pencil"></i> Edit </s:a> <!--  REMOVE TEAM --> <s:url
													id="removeURL" action="removeTeam.action">
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
						<!-- end team list -->

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->