package com.teleportcall.dto;

import java.sql.Timestamp;

import lombok.Data;

public @Data class AbstractDto {

	private Long pkey;
    private Boolean deleted;
    private String creator;
    private Timestamp created;
    private String changer;
    private Timestamp changed;
    private Long version;
}
