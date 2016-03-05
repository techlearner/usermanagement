package com.teleportcall.util;

import lombok.Data;

public @Data class UserResponse {

	private Object result;
	
	private UserException exception;
	
	private Pagination pagination;
	
	public UserResponse() {
		
	}
	
	public UserResponse(Object result, UserException exception, Pagination pagniation) {
		this.result = result;
		this.exception = exception;
		this.pagination = pagniation;
	}
}
