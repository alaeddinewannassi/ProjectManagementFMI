/**
 * 
 */
package com.adp.control.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author M.BENAMOR
 *
 */
public class AbstractAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	// Session
	private Map<String, Object> session;
	
	private String loggedInUser;
	
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	public String getLoggedInUser() {
		if(ServletActionContext.getRequest().getSession().getAttribute("loggedInUser") != null){
			loggedInUser = (String) ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		}
		return loggedInUser;
	}
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	/*
	 // Log Out user
    public String logOut() {
            session.remove("loginId");
            addActionMessage("You have been Successfully Logged Out");
            return SUCCESS;
    }
    
    // Login user
    public String login() {
            if (loggedInUser.isEmpty()) {
                    addActionError("Username can't be blanked");
                    return LOGIN;
            } else {
                    session.put("loginId", loggedInUser);
                    return SUCCESS;
            }
    }
    */
    public String getUserName() {
        return loggedInUser;
        }

    public void setUserName(String loggedInUser) {
        this.loggedInUser = loggedInUser;
}



}
