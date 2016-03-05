package com.teleportcall.dto;

import java.util.List;

import com.teleportcall.model.UserContact;

import lombok.Data;

public @Data class UserDto {

	private String email;

	private String mobileNo;

	private String userName;

	private String password;

	private List<UserContactDto> userContact;
}
