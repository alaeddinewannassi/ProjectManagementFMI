<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Add a Third Party </h2>
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
                    
                    <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" method="post" action="saveThirdParty.action">
						
						
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">First Name <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="firstName" name="firstName" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Last Name <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="lastName" name="lastName" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
             
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <div id="gender" class="btn-group" data-toggle="buttons">
                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                              <input type="radio" name="gender" value="male"> &nbsp; Male &nbsp;
                            </label>
                            <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                              <input type="radio" name="gender" value="female"> Female
                            </label>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="birthday">Date Of Birth <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="birthday" name="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Job title <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="jobTitle" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                        </div>
                      </div>
                      </br>
                	     <s:select  cssStyle="padding:10px ; margin-left: 193px; margin-top: -120px;" name="teamName" list="teams" listKey="teamName" listValue="teamName" 
	                         headerKey="0" headerValue="Select a team" label="Select a team" />
                 		    </br>
                 		    </br>
					          
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Telephone  <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="phone" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                        </div>
                      </div>
                      
                    </br>
                  
                    <div class="form-group">
			    <label style="margin-left: 160px" for="exampleInputFile">Profile Image  <span class="required">*</span> </label>
			    <input style="padding:10px ; margin-left: 300px; margin-top: -30px" type="file" name="thirdPartyImage" class="form-control-file" id="thirdPartyImage" aria-describedby="fileHelp">
			    <small style="padding:10px ; margin-left: 300px; id="fileHelp" class="form-text text-muted">FMI supports images in JPEG, PNG and Adobe Illustrator (AI) formats</small>
			  </div>  
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Missions  <span class="required">*</span>
                        </label> 
                           <div style="margin-right: 470px">  
                      <s:select  cssClass="selectpicker" multiple="true" list="missions" listKey="missionName" listValue="missionName" headerValue="select missions"
                      label="Select missions" headerKey="0" name="selectedMissions"/>
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
		
	
      
  	 <script>
  		$(document).ready(function () {
    	$('.selectpicker').selectpicker();
  			});
	</script>  
            
           
            
            
            
            