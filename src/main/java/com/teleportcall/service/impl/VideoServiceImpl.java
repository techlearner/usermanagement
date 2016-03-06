package com.teleportcall.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teleportcall.dto.VideoDto;
import com.teleportcall.model.Video;
import com.teleportcall.repository.VideoRepository;
import com.teleportcall.service.VideoService;
import com.teleportcall.util.UserException;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired private VideoRepository repo;
	
	@Autowired private DozerBeanMapper mapper;

	@Override
	public VideoDto upsert(VideoDto dto) throws UserException {
		Video video = mapper.map(dto, Video.class);
		repo.save(video);
		return mapper.map(video, VideoDto.class);
	}

	@Override
	public VideoDto findById(Long pkey) throws UserException {
		Video video = repo.findOne(pkey);
		return mapper.map(video, VideoDto.class);
	}

	@Override
	public Page<Video> fetchAll(Integer pageNo, Integer pageSize) throws UserException {
		// TODO Auto-generated method stub
		
		PageRequest request = new PageRequest(pageNo, pageSize);
		Page<Video> videoList = repo.findAll(request);
		return videoList;
	}

}
