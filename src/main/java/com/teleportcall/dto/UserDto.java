package com.teleportcall.dto;

import lombok.Data;

public @Data class UserDto extends AbstractDto {

	private String userId;
	
	private String email;

	private String mobileNo;

	private String userName;

	private String password;
	
	private Boolean isActivated;
	
	private String profileImageUrl;
	
	public String gcmKey;

}
