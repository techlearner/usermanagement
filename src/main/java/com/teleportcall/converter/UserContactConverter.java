package com.teleportcall.converter;

import java.util.List;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.teleportcall.dto.UserDto;
import com.teleportcall.model.User;
import com.teleportcall.model.UserContact;

public class UserContactConverter implements CustomConverter {

	@Autowired private DozerBeanMapper mapper;

	@Override
	public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
		if (source instanceof List && (!((List<UserContact>) source).isEmpty())) {
			for (UserContact userContact : ((List<UserContact>) source)) {
				
			}
		}
	
		return destination;
	}
	
	private UserDto getUser(User user) {
		return mapper.map(user, UserDto.class);
	}
}
