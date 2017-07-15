package com.adp.control.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.UserService;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.ResetUtil;

public class LostPasswordAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	UserService userService ;
	
	private String email ;
	
	private String token ;
	
	private String password ;
	
	
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String execute() throws ADPException {
		addActionMessage("please enter your e-mail adress ! ");
		return SUCCESS ;
	}
	
	public String reset() throws ADPException {
		
		if(!userService.userExistsinDB(email)){
			addActionError("user does not exist !");
			return "login" ;
		}
		
		UserEntity user = userService.getUserByMail(email);
		HttpServletRequest request = ServletActionContext.getRequest();
		String link = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/confirmReset.action?token="+user.getConfirmationToken();
		ResetUtil Sender = new ResetUtil();
		Sender.sendEmail(user.getLogin(),email,link);
		addActionMessage("please check your mail inbox ! ");
		
		return SUCCESS ;
	}
	
	public String confirmReset() throws ADPException {
		UserEntity user = userService.getUserByToken(token);
		if (user== null){
			addActionError("play away hacker ! ");
			return "login" ;
		}
		
		return SUCCESS ;
	}
	
	public String finalReset() throws ADPException {
		UserEntity user = userService.getUserByToken(token);
		user.setPassword(password);
		userService.updateUser(user);
		
		addActionMessage(user.getLogin()+" , your password was updated successfully !");
		
		return SUCCESS ;
	}

	
	
}
