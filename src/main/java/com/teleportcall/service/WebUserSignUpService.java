package com.teleportcall.service;

import org.springframework.data.domain.Page;

import com.teleportcall.dto.WebUserSignUpDto;
import com.teleportcall.model.WebUserSignup;
import com.teleportcall.util.UserException;

public interface WebUserSignUpService {

	WebUserSignUpDto upsert(WebUserSignUpDto dto) throws UserException;
	
	Page<WebUserSignup> fetchAll(Integer pageNo, Integer pageSize) throws UserException;
}
