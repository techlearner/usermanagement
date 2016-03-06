package com.teleportcall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="video")
public @Data class Video extends AbstractEntity {

	@Column(name="title", unique=true)
	private String title;
	
	@Column(name="url")
	private String url;
	
	@Column(name="is_locked")
	private Boolean isLocked;
}
