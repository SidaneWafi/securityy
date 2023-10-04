package com.classroom.demo.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity(name="users")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = -5700130538955316868L;
	@Id
	@GeneratedValue
	private long id ;
	
	private String userId ;
	
	@Column(nullable=false,length=50)
	private String firstName ;
	
	@Column(nullable=false,length=50)
	private String lastName;
	
	@Column(nullable=false,length=120,unique=true)//
	private String email;
	
	@Column(nullable=false)
	private String encryptedpassword;
	
	@Column(nullable=true)
	private String emailVerificationToken;
	
	@Column(nullable=false)//columnDefinition="boolean defult false"
	private Boolean emailVerificationStatuts=false;


	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEncryptedpassword() {
		return encryptedpassword;
	}


	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}


	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}


	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}


	public Boolean isEmailVerificationStatuts() {
		return emailVerificationStatuts;
	}


	public void setEmailVerificationStatuts(Boolean emailVerificationStatuts) {
		this.emailVerificationStatuts = emailVerificationStatuts;
	}
	
	

}
