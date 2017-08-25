<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
		id="signin"></a>

	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				<form id="loginForm" action="resetPassword.action" method="post">
					<h1>Your email Adress</h1>

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
						<input id="email" name="email" type="text" class="form-control"
							value="<s:property value="email"/>" />
					</div>

					<div>
						<button type="submit">Submit</button>

					</div>

					<div class="clearfix"></div>

					<br />
		</div>
		</form>
		</section>
	</div>

</div>


