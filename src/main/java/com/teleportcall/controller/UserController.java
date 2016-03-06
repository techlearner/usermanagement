package com.teleportcall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teleportcall.dto.UserDto;
import com.teleportcall.service.UserService;
import com.teleportcall.util.UserException;
import com.teleportcall.util.UserResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private UserService userService;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ResponseEntity<UserResponse> fetchUser(@PathVariable("userId")String userId) {
		
		try {
			UserDto dto = userService.fetchUser(userId);
			return new ResponseEntity<UserResponse>(new UserResponse(dto, null, null), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Exception while fetching user details : "+e.getMessage());
			return new ResponseEntity<UserResponse>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="/contacts/{userId}", method=RequestMethod.POST)
	public ResponseEntity<UserResponse> addUserContact(@PathVariable("userId")String userId, 
			@RequestBody UserDto user) {
		
		try {
			UserDto dto = userService.addContacts(userId, user);
			return new ResponseEntity<UserResponse>(new UserResponse(dto, null, null), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Exception while fetching user details : "+e.getMessage());
			return new ResponseEntity<UserResponse>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/contacts/{userId}", method=RequestMethod.GET)
	public ResponseEntity<UserResponse> getUserContact(@PathVariable("userId")String userId) {
		
		try {
			List<UserDto> dto = userService.getUserContacts(userId);
			return new ResponseEntity<UserResponse>(new UserResponse(dto, null, null), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Exception while fetching user details : "+e.getMessage());
			return new ResponseEntity<UserResponse>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity<UserResponse> signupUser(@RequestBody UserDto userDto) {
		
		try {
			UserDto dto = userService.upsertUser(userDto);
			return new ResponseEntity<UserResponse>(new UserResponse(dto, null, null), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<UserResponse>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
