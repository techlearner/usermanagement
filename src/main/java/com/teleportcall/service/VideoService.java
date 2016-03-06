package com.teleportcall.service;

import org.springframework.data.domain.Page;

import com.teleportcall.dto.VideoDto;
import com.teleportcall.model.Video;
import com.teleportcall.util.UserException;

public interface VideoService {

	VideoDto upsert(VideoDto dto) throws UserException;
	
	VideoDto findById(Long pkey) throws UserException;
	
	Page<Video> fetchAll(Integer pageNo, Integer pageSize) throws UserException;
}
