<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Add a Contributor </h2>
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
                    
                    <s:form theme="simple" id="demo-form2" cssClass="form-horizontal form-label-left"  method="post" action="saveThirdParty.action" enctype="multipart/form-data">
						
						
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
                        <s:label  cssClass="control-label col-md-3 col-sm-3 col-xs-12" value="First Name" for="firstName"/>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <s:textfield  id="firstName" name="firstName" cssClass="form-control col-md-7 col-xs-12"/>
                        </div>
                      </div>
                      <div class="form-group">
                       <s:label  cssClass="control-label col-md-3 col-sm-3 col-xs-12" value="Last Name" for="lastName"/>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                         <s:textfield  id="lastName" name="lastName" cssClass="form-control col-md-7 col-xs-12"/>
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label style="padding-left:100px" class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <div id="gender" class="btn-group" data-toggle="buttons">
                          <label class="btn btn-default" style="text-align: center ; padding-left: 20px ; padding-right: 20px" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
							<s:radio id="gender" name="gender" title="male"  list="#{'Male' : 'Male'}"/>
							</label>
							<label class="btn btn-primary" style="text-align: center ; padding-left: 20px ; padding-right: 20px" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
							<s:radio id="gender" name="gender" title="female" list="#{ 'Female' : 'Female'}"/>
							</label>
                          </div>
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <s:label name="jobTitle" cssClass="control-label col-md-3 col-sm-3 col-xs-12" value="Job title" for="jobTitle"/>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <s:textfield id="jobTitle" name="jobTitle" cssClass="date-picker form-control col-md-7 col-xs-12" />
                        </div>
                      </div>
					    <div class="form-group">
                        <s:label name="adresse" cssClass="control-label col-md-3 col-sm-3 col-xs-12" value="Adresse" for="adresse"/>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <s:textfield id="adresse" name="adresse" cssClass="date-picker form-control col-md-7 col-xs-12" />
                        </div>
                      </div>       
                      <div class="form-group">
                        <s:label cssClass="control-label col-md-3 col-sm-3 col-xs-12" value="Telephone" for="phone"/> 
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <s:textfield id="phone" name="phone" cssClass="date-picker form-control col-md-7 col-xs-12" />
                        </div>
                      </div>
                      
                  
               <div class="form-group">
			    <s:label cssStyle="margin-left: 160px" value="Profile Image :*" for="upload"  />
			  <s:file cssStyle="padding:10px ; margin-left: 300px; margin-top: -30px" id="upload" name="profileImage"  />
			   <small style="padding:10px ; margin-left: 300px;" id="fileHelp" class="form-text text-muted">FMI supports images in JPEG, PNG and Adobe Illustrator (AI) formats</small>
			  </div>  
                    
                <div class="ln_solid"></div>
                <div class="form-group">
                  <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
  					<s:submit cssClass="btn btn-success" value="Submit"/>
                  </div>
                </div>
				
                    </s:form>
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
            