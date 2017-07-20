<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  
        <!-- page content -->
        <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Affect Contributor </h2>
                    
                    
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
                    <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" method="get" action="doAffectThirdParty.action">
						
						
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
        			<table class="table table-bordered table-hover table-sortable" id="tab_logic">
        				<thead>
        					<tr >
        						
        						<th class="text-center">
        							Mission Name
        						</th>
                                <th class="text-center">
            						Start Date
        						</th>
        						<th class="text-center">
        							End Date
        						</th>
        						
                				<th class="text-center" style="border-top: 1px solid #ffffff; border-right: 1px solid #ffffff;">
        						</th>
        					</tr>
        				</thead>
        				
        				<tbody>
            				<tr id='addr0' data-id="0" >
        						<td data-name="selectedMission">
        						    <s:select id="missionSelect" theme="simple"  list="missions" listKey="missionName" listValue="missionName" 
                      headerKey="0" headerValue="Select a mission"  name="selectedMission" />
        						</td>
                                <td data-name="startDate">
                                    <input type="date" name="startDate" />
        						</td>
        						<td data-name="endDate">
                                    <input type="date" name="endDate" />
        						</td>
                                <td data-name="del">
                                    <button name="del0" class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>
                                </td>
        					</tr>
        				</tbody>
        			</table>
        			<input type="submit"  class="btn btn-success" value="Submit" />
        			</form>
        		</div>
        	</div>
        	<a id="add_row" class="btn btn-default pull-right">Add Row</a>
            
			        </div>
			        
			    </div>
			</div>
		</div>
	</div>
</div>


