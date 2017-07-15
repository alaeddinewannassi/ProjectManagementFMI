/**
 * 
 */
package com.adp.control.actions;


import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.UserService;

/**
 * @author M.BENAMOR
 *
 */
public class LogoutAction extends AbstractAction {

	private static final long serialVersionUID = -3498273877470668895L;

	@Autowired
	UserService userService ;
	

	public String execute() {  
	
		ServletActionContext.getRequest().getSession().invalidate();
	    
		return SUCCESS;  
  
	} 
}
