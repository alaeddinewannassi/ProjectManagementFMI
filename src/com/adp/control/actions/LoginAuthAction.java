/**
 * 
 */
package com.adp.control.actions;


import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.UserService;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;



/**
 * @author M.BENAMOR
 *
 */
public class LoginAuthAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	UserService userService ;
	
	private String username ;
	
	private String email;
	
	private String password;
	
	 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws ADPException {  

		if (!check()) {
			addActionError("verify connexion fields (*)!");
			return "login";
		}
		
		UserEntity user = userService.getUser(email, password);
		
		if (user == null){
			addActionError("incorrect credentials !");
			return "login";
		}
		
		String loggedInUser = user.getLogin();
		
		// session prepare 
		setLoggedInUser(loggedInUser);
		ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", user);
	
		return SUCCESS;  
  
	} 
	
	private boolean check() {
		if(StringUtil.isEmpty(email) || StringUtil.isEmpty(password)){
			return false;
		}
		
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
