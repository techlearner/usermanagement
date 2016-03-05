package com.teleportcall.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teleportcall.model.Video;

@Repository
public interface VideoRepository extends PagingAndSortingRepository<Video, Long>{

}
