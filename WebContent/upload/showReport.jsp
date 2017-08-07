<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Search Report Filters : </h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br>
                    
                    
                    
                     <!-- JavaScript Plugins -->
    <script>
        function getTeams(){

            var selectedProject = $('#project').val();

            $.getJSON('doShowReport.action', {'selectedProject': selectedProject},
            function(data) {
    		//alert(data.teams);
              var teamList = (data.teams);
				
                var options = $("#team");
                options.find('option')
                .remove()
                .end();
                options.append($("<option/>").val("0").text("Select a team"));
              $.each(teamList, function() {
                    options.append($("<option/>").val(this).text(this));
                });
            }
        );}

        function getThirdParties(){

            var selectedTeam = $('#team').val();

            $.getJSON('doShowReport.action', {'selectedTeam': selectedTeam},
            function(data) {
    		//alert(data.thirdParties);
              var teamList = (data.thirdParties);
				
                var options = $("#thirdParty");
                options.find('option')
                .remove()
                .end();
                options.append($("<option/>").val("0").text("Select thirdParty"));
              $.each(teamList, function() {
                    options.append($("<option/>").val(this).text(this));
                });
            }
        );}
     
        
    </script>

    <!-- jQuery-UI Dependent Scripts -->
                    
                    
                    
                    
                     <s:url id="URL" action="timesheetViewReport.action"  includeContext="false">
	                          <s:param name="selectedMonth" value="%{selectedMonth}"></s:param>
	                          </s:url>
	                          
                   <s:form id="demo-form2"  cssClass="form-horizontal form-label-left" method="post" action="%{URL}">
						
						
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
                 	 	<label  class="control-label col-md-3 col-sm-3 col-xs-12"  for="selectedMonth">Timesheet Month :</label>
                       <s:select cssStyle="padding:10px ; margin-left: 190px; margin-top: -360px;"  id="month"  name="selectedMonth" list="timesheets"  
	                         headerKey="0" headerValue="Select a month" label="Select a month" />
                 		    </div>
                 		    </br>
					    
					    
					    <div class="form-group">
                 	 	<label  class="control-label col-md-3 col-sm-3 col-xs-12"  for="selectedMonth">Project Name :</label>
                       <s:select cssStyle="padding:10px ; margin-left: 190px; margin-top: -310px;" id="project" onchange="getTeams()" name="selectedProject" list="projects"  listKey="projectName" listValue="projectName" 
	                         headerKey="0" headerValue="Select a project" label="Select a project" />
                 		    </div>
                 		    </br>
                      
                 		   
                       <div class="form-group">
                 	 	<label class="control-label col-md-3 col-sm-3 col-xs-12"  for="selectedMonth">Team Name :</label>
                       <s:select id="team" cssStyle="padding:10px ; margin-left: 190px; margin-top: -260px;" onchange="getThirdParties()"  name="selectedTeam" list="teams" listKey="teamName" listValue="teamName" 
	                         headerKey="" headerValue="Select a team" label="Select a team" />
                 		    </div>
                 		    </br>

 					<div class="form-group">
                 	 	<label  class="control-label col-md-3 col-sm-3 col-xs-12"  for="selectedMonth">ThirdParty Name :</label>
                       <s:select id="thirdParty"  cssStyle="padding:10px ; margin-left: 190px; margin-top: -200px;" name="thirdPartyName" list="thirdParties"  listKey="fullName" listValue="fullName" 
	                         headerKey="0" headerValue="Select thirdParty" label="Select thirdParty" />
                 		    </div>
                 		    </br>
                       
                 		    </br>
                 		                     		    
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
		
	
      
