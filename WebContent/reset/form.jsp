<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  

<script type="text/javascript">
function check_pass() {
	 var pass1 = document.getElementById("password").value;
	    var pass2 = document.getElementById("confirm_password").value;
	    var ok = true;
	    if (pass1 != pass2) {
	        //alert("Passwords Do not match");
	        document.getElementById("pass1").style.borderColor = "#E34234";
	        document.getElementById("pass2").style.borderColor = "#E34234";
	        ok = false;
	    }
		return ok ;	    
}

</script>



<div>
	<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
		id="signin"></a>

	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				
				
				<form id="loginForm" action="finalReset.action" method="post" >
					<h1> Reset &nbsp; Form </h1>
					
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


			<input type="hidden" name="token" value="<s:property value="token" />"  required="required" class="form-control col-md-7 col-xs-12">
					<div>
					
					
					New Password :	<input id="password" name="password" type="password" class="form-control"  />
					</div>
					
					<div>
					Retype Password :	<input id="confirm_password" name="confirm_password" type="password" class="form-control"  />
					</div>
					
					<div>
						<button type="submit" name="submit" > Submit </button>
					
					</div>

					<div class="clearfix"></div>

						<br />

					</div>
				</form>
			</section>
		</div>

			</div>


