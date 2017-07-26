<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Import Timesheet </h2>
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
                    
                    <s:form theme="simple" id="demo-form2" cssClass="form-horizontal form-label-left"  method="post" action="timesheetResult.action" enctype="multipart/form-data">
						
						
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
                 	
                      <div class="form-group" style=" margin-left: 200px">
                      <s:label for="projectSelect" value= "Project Name : "/> &nbsp; &nbsp;   
                      <s:select id="projectSelect" cssStyle="padding:10px ; margin-left:100px ; margin-top: -120px;" cssClass="selectpicker" list="projects"  listKey="projectName" listValue="projectName" 
                      headerKey="0" headerValue="Select a project" label="Select a project"   name="selectedProject" />
                      
                      
                      </div>
                      <br>
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="timesheet" style="margin-left: 40px"> Import timesheet : </label> 
                        <div class="col-md-6 col-sm-6 col-xs-12">
                         <input style="margin-left: 40px" type="file" name="timesheet" />
                        </div>
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
		
	
      
  
						
						