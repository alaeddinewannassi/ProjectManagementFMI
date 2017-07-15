<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  

<script type="text/javascript">
function check_pass() {
    if (document.getElementById('password').value ==
            document.getElementById('confirm_password').value) {
        document.getElementById('submit').disabled = false;
    } else {
        document.getElementById('submit').disabled = true;
    }
}

</script>



<div>
	<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
		id="signin"></a>

	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				
				<input type="hidden" value="<s:property value="token" />" name="token" />
				<form id="loginForm" action="finalReset.action" method="post">
					<h1> Login Form </h1>
					
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

					
					
					
					<div>
					
					
					new Password :	<input id="password" name="password" type="password" class="form-control" onchange='check_pass();' />
					</div>
					
					<div>
					retype Password :	<input id="confirm_password" name="confirm_password" type="password" class="form-control" onchange='check_pass();' />
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


