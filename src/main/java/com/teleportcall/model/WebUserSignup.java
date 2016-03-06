package com.teleportcall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="web_user_signup")
public @Data class WebUserSignup extends AbstractEntity {

	@Column(name="user_email", unique=true)
	private String userEmail;
	
	@Column(name="user_name", unique=true)
	private String userName;
}
