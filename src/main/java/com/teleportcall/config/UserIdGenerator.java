package com.teleportcall.config;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserIdGenerator {

	public static Long getNextUserId() {
		Long txnId = getNextAuth();
		String val = txnId.toString();
		if (val.length() > 9)
			val = val.substring(0, 8);
		return Long.parseLong(val);
	}

	public static Long getNextAuth() {
		return Math.abs(UUID.randomUUID().getLeastSignificantBits());
	}
}