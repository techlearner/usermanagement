package com.teleportcall.service;

import com.teleportcall.dto.UserDto;
import com.teleportcall.util.UserException;

public interface UserService {

	UserDto fetchUser(String userId) throws UserException;
}
