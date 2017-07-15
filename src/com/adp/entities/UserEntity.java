/**
 * 
 */
package com.adp.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author M.BENAMOR
 *
 */
@Entity
@Table(name = "FMI_USER")
public class UserEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mail;
	private String login;
	private String password;
	private boolean verified;
	private Date dateCreation ;
	private String confirmationToken;

	 
	
	public String getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public UserEntity(String mail, String login, String password) {
		super();
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.verified = false;
		this.dateCreation= new Date();
		this.confirmationToken= UUID.randomUUID().toString();
	}
	public UserEntity() {
		super();
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
