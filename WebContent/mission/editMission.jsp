<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Edit Mission </h2>
                    

				
                    
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
                    <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" method="post" action="editMission.action">
						
						
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="id">Mission ID :<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                       
                          <input type="text" name="id" value="<s:property value="id"/>"  required="required" class="form-control col-md-7 col-xs-12" hidden>
                        </div>
                      </div> 
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="missionName">Mission Name :<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                       
                          <input type="text" name="missionName" value="<s:property value="mission.missionName" />"  required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="budget" class="control-label col-md-3 col-sm-3 col-xs-12">Budget :<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="budget" required="required" value="<s:property value="mission.budget" />"  class="form-control col-md-7 col-xs-12"> 
                        </div>
                      </div>
                      
                       <div class="form-group">
                        <label for="budget" class="control-label col-md-3 col-sm-3 col-xs-12">Description :<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" name="description" required="required" value="<s:property value="mission.description" />"  class="form-control col-md-7 col-xs-12"> 
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
		
	
      
