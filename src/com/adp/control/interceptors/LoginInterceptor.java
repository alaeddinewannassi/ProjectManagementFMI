/**
 * 
 */
package com.adp.control.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.adp.control.actions.ConfirmAction;
import com.adp.control.actions.LoginAction;
import com.adp.control.actions.LoginAuthAction;
import com.adp.control.actions.SubscribeAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author M.BENAMOR
 *
 */
public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	private static final long serialVersionUID = -5289243113189837623L;

	private static final Log log = LogFactory.getLog(LoginInterceptor.class);  
	private static final String USER_HANDLE = "loggedInUser";  
	private static final String LOGIN_ATTEMPT = "loginAttempt";
	public static Boolean calculating = false;
	 
	public void init() {  
		log.info("Intializing LoginInterceptor");  
	}  
	
	public void destroy() {  
		log.info("Destroying LoginInterceptor");  
	} 

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final ActionContext context = invocation.getInvocationContext();  
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);  
		HttpSession session = request.getSession(true);  
		
		// Is there a "user" object stored in the user's HttpSession?  
		Object user = session.getAttribute(USER_HANDLE);  
		Object action = invocation.getAction();
		if (user == null) {  
			// The user has not logged in yet.  
				  
			// Is the user attempting to log in right now?  
			String loginAttempt = request.getParameter(LOGIN_ATTEMPT);  
				  
			/* The user is attempting to log in. */  
			if (!StringUtils.isBlank(loginAttempt) || action instanceof SubscribeAction || action instanceof ConfirmAction) {
				return invocation.invoke();  
			}
			
			return "login";  
		
		} else {  
			
			if(action instanceof LoginAction || action instanceof LoginAuthAction){
				return "logout";
			}
           
			// Execute the called url.	
			return invocation.invoke();  
		}  
	}  
	
}
