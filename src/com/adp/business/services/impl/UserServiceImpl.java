/**
 * 
 */
package com.adp.business.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adp.business.dao.UserDAO;
import com.adp.business.services.UserService;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;

/**
 * @author M.BENAMOR
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public Long enregistrer(UserEntity u) throws ADPException {
		
		
		return userDAO.addUser(u);
		
	}
	public UserEntity getUserByToken(String token)
			throws ADPException {
		return userDAO.getUserByToken(token);
	}
	public UserEntity updateUser(UserEntity u) throws ADPException {
		return userDAO.updateUser(u);
	}
	public UserEntity getUser(String email, String password) throws ADPException {
		// TODO Auto-generated method stub
		return userDAO.getUser(email, password);
	}
	public boolean userExistsinDB(String email) throws ADPException {
		// TODO Auto-generated method stub
		return userDAO.userExistsinDB(email);
	}
	public UserEntity getUserByMail(String mail) throws ADPException {
		// TODO Auto-generated method stub
		return userDAO.getUserByMail(mail);
	}

	
}

