package com.teleportcall.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_contact")
public class UserContact extends AbstractEntity {
	
	private String contactMappingkey;
	
	private User contactUser;

	private User owner;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_fkey", nullable = false)
	public User getOwner() {
		return owner;
	}

	public void setOwner(User user) {
		this.owner = user;
	}

	@Column(name="contact_mapping_key", unique=true)
	public String getContactMappingkey() {
		return contactMappingkey;
	}

	public void setContactMappingkey(String contactMappingkey) {
		this.contactMappingkey = contactMappingkey;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contact_user_fkey")
	public User getContactUser() {
		return contactUser;
	}

	public void setContactUser(User contactUser) {
		this.contactUser = contactUser;
	}

}
