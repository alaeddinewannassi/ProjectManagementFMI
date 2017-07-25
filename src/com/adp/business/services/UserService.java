/**
 * 
 */
package com.adp.business.services;

import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;

/**
 * @author M.BENAMOR
 *
 */
public interface UserService {

	public Long enregistrer(UserEntity u) throws ADPException;
	public UserEntity getUserByToken(String token)throws ADPException ;
	public UserEntity getUser(String email, String password)throws ADPException ;
	public UserEntity updateUser(UserEntity u)throws ADPException ;
	public  boolean userExistsinDB(final String email) throws ADPException ;
	public UserEntity getUserByMail(String mail)throws ADPException ;
	
}
