<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  

<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>


 <div class="right_col" role="main">
        <div class="clearfix"></div>
            <div class="row">
<div class="panel panel-default">
  <div class="panel-heading">

                     <div class="x_title">
    <h3 class="panel-title">Affect Third Party</h3>
  </div>
 

  <div class="panel-body">
        <div class="container">
            <div class="row clearfix">
            	<div class="col-md-12 table-responsive">
            	 <form action="doAffectThirdParty.action" method="get" >
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
            				<tr id='addr0' data-id="0" class="hidden">
        						<td data-name="selectedMission">
        						  <div>
        						    <s:select id="missionSelect" theme="simple"  list="missions" listKey="missionName" listValue="missionName" 
                      headerKey="0" headerValue="Select a mission"  name="selectedMission" />
                      				<input type="hidden" value="selectedMission"/>
        						  </div>
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


