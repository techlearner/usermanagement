package com.teleportcall.service;

import java.util.List;

import com.teleportcall.dto.UserDto;
import com.teleportcall.util.UserException;

public interface UserService {

	UserDto fetchUser(String userId) throws UserException;
	
	UserDto upsertUser(UserDto user) throws UserException;
	
	UserDto addContacts(String userId, UserDto contact) throws UserException;
	
	List<UserDto> getUserContacts(String userId) throws UserException;
}
