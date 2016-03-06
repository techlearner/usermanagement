package com.teleportcall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleportcall.config.UserIdGenerator;
import com.teleportcall.dto.UserDto;
import com.teleportcall.model.User;
import com.teleportcall.model.UserContact;
import com.teleportcall.repository.UserContactRepo;
import com.teleportcall.repository.UserRepository;
import com.teleportcall.service.UserService;
import com.teleportcall.util.UserException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepo;
	
	@Autowired private DozerBeanMapper mapper;
	
	@Autowired private UserContactRepo userContactRepo;
	
	@Override
	public UserDto fetchUser(String userId) throws UserException {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(userId)) {
			throw new UserException("UserId is Empty", "UserId is Empty", null, null);
		}
		
		User user = userRepo.findUserByUserId(userId);
		
		if (user == null) {
			throw new UserException("User is not found", "User is not found", null, null);
		}
		
		return mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto upsertUser(UserDto userDto) throws UserException {
		// TODO Auto-generated method stub
		User user =  null;
		if (!StringUtils.isEmpty(userDto.getMobileNo())) {
			try {
			user = findByMobileNo(userDto.getMobileNo());
			} catch (UserException e) {
				userDto.setIsActivated(true);
			}
		}
		
		
		if (user == null && StringUtils.isEmpty(userDto.getUserId())) {
			userDto.setUserId(UserIdGenerator.getNextUserId().toString());
		}
		
		
		user = mapper.map(userDto, User.class);
		userRepo.save(user);
		return mapper.map(user, UserDto.class);
	}
	
	private User findByMobileNo(String mobileNo) throws UserException {
		
		if (StringUtils.isEmpty(mobileNo)) {
			throw new UserException("Mobileno is empty", "Mobileno is empty", null, null);
		}
		
		User user =  userRepo.findUserByMobileNo(mobileNo);
		
		if (user == null) {
			throw new UserException("User is not found", "User is not found", null, null);
		}
		return user;
	}

	@Override
	public UserDto addContacts(String userId, UserDto contact) throws UserException {
		// TODO Auto-generated method stub
		
		if (StringUtils.isEmpty(userId)) {
			throw new UserException("UserId is Empty", "UserId is Empty", null, null);
		}
		
		User owner = userRepo.findUserByUserId(userId);
		User contactUser = null;
		try {
			contactUser = findByMobileNo(contact.getMobileNo());
		} catch (UserException e) {

		}
		
		if (contactUser == null) {
			contactUser = new User();
			Long userid = UserIdGenerator.getNextUserId();
			contactUser.setUserId(userid.toString());
			contactUser.setEmail(userid+"@test.com");
			contactUser.setUserName(""+userid);
		}
		UserContact usercontact = new UserContact();
		usercontact.setOwner(owner);
		usercontact.setContactUser(contactUser);
		String contactMappingkey = ""+owner.getUserId()+contactUser.getUserId();
		usercontact.setContactMappingkey(contactMappingkey);
		
		
		//userRepo.save(user);
		userContactRepo.save(usercontact);
		return mapper.map(owner, UserDto.class);
	}

	@Override
	public List<UserDto> getUserContacts(String userId) throws UserException {
		// TODO Auto-generated method stub
		User user =  userRepo.findUserByUserId(userId);
		
		
		if (user!=null) {
			List<UserContact> userContactList = userContactRepo.findUserContactByOwnerId(userId);
			return convertUserDto(userContactList);
		}
		return null;
	}

	private List<UserDto> convertUserDto(List<UserContact> userList) {
		List<UserDto> userDtoList = new ArrayList<>();
		for (UserContact user:userList) {
			userDtoList.add(mapper.map(user.getContactUser(), UserDto.class));
		}
		return userDtoList;
	}
}
