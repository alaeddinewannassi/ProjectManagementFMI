/**
 * 
 */
package com.adp.business.dao;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;

/**
 * @author M.BENAMOR
 *
 */
public interface UserDAO extends GenericDAO<UserEntity>{

	Long addUser(UserEntity u) throws ADPException;
	public UserEntity getUser(String email, String password)throws ADPException ;
	public UserEntity getUserByToken(String token)throws ADPException ;
	public UserEntity getUserByMail(String mail)throws ADPException ;
	public UserEntity updateUser (UserEntity u)throws ADPException  ;
	public  boolean userExistsinDB(final String email) throws ADPException ;
}
