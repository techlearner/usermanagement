package com.teleportcall.dto;

import lombok.Data;

public @Data class WebUserSignUpDto extends AbstractDto {

	private String userEmail;
	
	private String userName;
}
