package com.teleportcall.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teleportcall.dto.WebUserSignUpDto;
import com.teleportcall.model.WebUserSignup;
import com.teleportcall.repository.WebUserSignUpRepo;
import com.teleportcall.service.WebUserSignUpService;
import com.teleportcall.util.UserException;

@Service
public class WebUserSignUpServiceImpl implements WebUserSignUpService {

	@Autowired private DozerBeanMapper mapper;
	
	@Autowired private WebUserSignUpRepo repo;
	
	@Override
	public WebUserSignUpDto upsert(WebUserSignUpDto dto) throws UserException {
		// TODO Auto-generated method stub
		
		if (dto == null || StringUtils.isEmpty(dto.getUserEmail())) {
			throw new UserException("Data is invalid", "Data is invalid", null, null);
		}
		
		WebUserSignup signup = mapper.map(dto, WebUserSignup.class);

		try {
			repo.save(signup);
		} catch (Exception e) {
			throw new UserException(e.getMessage(), e.getMessage(), null, null);
		}
		
		return mapper.map(signup, WebUserSignUpDto.class);
	}

	@Override
	public Page<WebUserSignup> fetchAll(Integer pageNo, Integer pageSize) throws UserException {
		PageRequest page = new PageRequest(pageNo, pageSize);
		Page<WebUserSignup> result = repo.findAll(page);
		return result;
	}

}
