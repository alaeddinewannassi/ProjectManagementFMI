package com.adp.control.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.UserService;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.EmailUtil;
import com.adp.utils.StringUtil;


public class SubscribeAction extends AbstractAction{

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserService userService ;


	
	private String login ;
	
	private String email ;
	
	private String password ;
	
	public String execute() {
		
		try {
			
			if (!check()) {
				addActionError("please verify the form fields !");
				return "login";
			}
			else if (userService.userExistsinDB(email)) {
				addActionError("There is an account with that email adress ");
				return "login";
			}
			
			
			HttpServletRequest request = ServletActionContext.getRequest();
			userService.enregistrer(new UserEntity(email, login, password));
			UserEntity user = userService.getUser(email, password);
			String link = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/confirm.action?token="+user.getConfirmationToken();
			EmailUtil Sender = new EmailUtil();
			Sender.sendEmail(login,email,link);
			
			
		} catch (ADPException e) {

			e.printStackTrace();
		}
		return SUCCESS;  	
	}
	private boolean check() {
		if(StringUtil.isEmpty(login) || StringUtil.isEmpty(email) || StringUtil.isEmpty(password)){
			return false;
		}
		
		return true;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
