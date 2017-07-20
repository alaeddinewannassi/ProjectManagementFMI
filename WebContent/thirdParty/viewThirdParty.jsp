<?xml version="1.0" encoding="utf-8"?>
<%@page import="com.adp.entities.ThirdPartyEntity"%>
<%@page import="java.io.FileOutputStream"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 

    
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>View Contributors</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
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
                  <div class="x_content">
                   
                    <div class="row">
                      <div class="col-md-12 col-sm-12 col-xs-12 text-center">
                        <ul class="pagination pagination-split">
                          <li><a href="#">A</a></li>
                          <li><a href="#">B</a></li>
                          <li><a href="#">C</a></li>
                          <li><a href="#">D</a></li>
                          <li><a href="#">E</a></li>
                          <li>...</li>
                          <li><a href="#">W</a></li>
                          <li><a href="#">X</a></li>
                          <li><a href="#">Y</a></li>
                          <li><a href="#">Z</a></li>
                        </ul>
                      </div>

                      <div class="clearfix"></div>

		<s:iterator value="thirdPartys" var="thirdParty" status="rowstatus">
                      <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
                        <div class="well profile_view">
                          <div class="col-sm-12">
                            <h4 class="brief"><i> <s:property value="jobTitle"/> </i></h4>
                            <div class="left col-xs-7">
                            <input type="hidden" value="<s:property value="id" />" />
                          
                           <s:url id="affectURL" action="affectThirdParty.action" >
                          <s:param name="id" value="%{id}"></s:param>
                          </s:url>
                            <h2> <s:a href="%{affectURL}"> <s:property value="firstName"/> <s:property value="lastName"/> </s:a></h2>
                              <p><strong>About: 	
                              
                              <s:iterator value="#thirdParty.interests" var="interest"  >
                             
                              <s:property value="#interest.interestName" /> </br> 
                        
                              </s:iterator>
						
							</strong>                              
                              
                              </p>
                              <ul class="list-unstyled">
                              
                                <li><i class="fa fa-building"></i> Address: <s:property value="adresse"/>  </li>
                                <li><i class="fa fa-phone"></i> Phone #: <s:property value="phone"/> </li>
                              </ul>
                            </div>
                            <div class="right col-xs-5 text-center">
                           
                              <img src="images/<s:property value="firstName"/>.jpg" alt="" class="img-circle img-responsive">
                            </div>
                          </div>
                          <div class="col-xs-12 bottom text-center">
                            <div class="col-xs-12 col-sm-6 emphasis">
                              <p class="ratings">
                                <a>4.0</a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star"></span></a>
                                <a href="#"><span class="fa fa-star-o"></span></a>
                              </p>
                            </div>
                            <div class="col-xs-12 col-sm-6 emphasis">
                             <s:url id="contactURL" action="contactThirdParty.action" >
	                          <s:param name="id" value="%{id}"></s:param>
	                          </s:url>
                             <s:a href="%{contactURL}"> <button   type="button" class="btn btn-success btn-xs"> <i class="fa fa-user"> 
                                </i> <i class="fa fa-comments-o"></i> </button></s:a>
                              <button type="button" class="btn btn-primary btn-xs">
                              <s:url id="profileURL" action="detailThirdParty.action" >
	                          <s:param name="id" value="%{id}"></s:param>
	                          </s:url>
                                <i  class="fa fa-user"> </i> <s:a cssStyle="color:inherit" href="%{profileURL}"> View Profile </s:a>
                              </button>
                            </div>
                          </div>
                        </div>
                      </div>
					</s:iterator>
				
                 
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

