package com.teleportcall.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_contact")
public class UserContact extends AbstractEntity {

	private User user;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_fkey")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
