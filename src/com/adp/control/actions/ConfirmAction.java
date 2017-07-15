package com.adp.control.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.UserService;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;

public class ConfirmAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserService userService ;
	String token ;
	String msg ;
	

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String execute() throws ADPException{
				
		try {
			
			
			UserEntity user = userService.getUserByToken(token);
			
			if(user==null){
				addActionError("Oops you have a problem with your confirmation link ! ");
			}
			else {
			user.setVerified(true);
			userService.updateUser(user) ;
			addActionMessage("account activated succefully ! ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
		
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
