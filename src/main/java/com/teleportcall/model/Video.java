package com.teleportcall.model;

import javax.persistence.Column;

import lombok.Data;

public @Data class Video extends AbstractEntity {

	@Column(name="title", unique=true)
	private String title;
	
	@Column(name="url")
	private String url;
	
	@Column(name="is_locked")
	private Boolean isLocked;
}
