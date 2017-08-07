<?xml version="1.0" encoding="utf-8"?>
<%@ taglib prefix="s" uri="/struts-tags"%>  

<div>
	<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
		id="signin"></a>

	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				<form id="loginForm" action="loginAuth.action" method="post">
					<h1>Manager Space</h1>
					<input type="hidden" name="loginAttempt" value="0" />
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
							 value="<s:property value="email"/>" required="" />
					</div>
					<div>
						<input id="password" name="password" type="password"
							class="form-control"/>
					</div>
					<div>
						<button type="submit">Log in</button>
						<a class="reset_pass" href="lostPassword.action">Lost your password?</a>
					</div>

					<div class="clearfix"></div>

					<div class="separator">
						<p class="change_link">
							New to site? <a href="#signup" class="to_register"> Create
								Account </a>
						</p>

						<div class="clearfix"></div>
						<br />

					</div>
				</form>
			</section>
		</div>

		<div id="register" class="animate form registration_form">
			<section class="login_content">
				<form action="subscribe.action" method="post">
					<h1>Create Account</h1>
					<div>
						<input type="text" class="form-control" placeholder="Username" name="login"
							required="" />
					</div>
					<div>
						<input type="email" class="form-control" placeholder="Email" name="email"
							required="" />
					</div>
					<div>
						<input type="password" class="form-control" placeholder="Password" name="password"
							required=""/>
					</div>
					<div>
					
					<div>
						<input class="btn btn-default submit" type="submit" value="submit" />
					</div>

					<div class="clearfix"></div>

					<div class="separator">
						<p class="change_link">
							Already a member ? <a href="#signin" class="to_register"> Log
								in </a>
						</p>

						<div class="clearfix"></div>
						<br />

					</div>
				</form>
			</section>
		</div>
	</div>
</div>

