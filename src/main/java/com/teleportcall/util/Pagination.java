package com.teleportcall.util;

import lombok.Data;

public @Data class Pagination {
	
	private Boolean isList;
	private Integer pageSize;
	private Integer pageNo;
	private Integer totalPages;
	private Integer totalElements;
}
