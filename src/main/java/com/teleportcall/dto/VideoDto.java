package com.teleportcall.dto;

import lombok.Data;

public @Data class VideoDto extends AbstractDto {

	private String title;

	private String url;

	private Boolean isLocked;
}
