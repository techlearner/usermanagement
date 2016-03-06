package com.teleportcall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends AbstractEntity {
	
	private String userId;

	private String email;
	
	private String mobileNo;
	
	private String userName;
	
	private String password;
	
	private Boolean isActivated;
	
	private String profileImageUrl;
	
	private String gcmKey;
	
	@Column(name="email", unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="mobile_no", unique=true)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name="name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="user_id", unique=true)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="is_activated")
	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	@Column(name="profile_image_url")
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Column(name="gcm_key")
	public String getGcmKey() {
		return gcmKey;
	}

	public void setGcmKey(String gcmKey) {
		this.gcmKey = gcmKey;
	}
	
	
}
