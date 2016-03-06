package com.teleportcall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teleportcall.model.Video;
import com.teleportcall.service.VideoService;
import com.teleportcall.util.Pagination;
import com.teleportcall.util.UserException;
import com.teleportcall.util.UserResponse;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired private VideoService videoService;
	
	@RequestMapping("/fetchall")
	public ResponseEntity<UserResponse> fetchAll(@RequestParam(name="pageNo", defaultValue="0", required=true)Integer pageNo,
			@RequestParam(name="pageSize", defaultValue="0", required=true)Integer pageSize) {
		
		try {
			Page<Video> videoRes = videoService.fetchAll(pageNo, pageSize);
			Pagination page = new Pagination();
			page.setIsList(true);
			page.setPageNo(pageNo);
			page.setTotalPages(new Integer(""+videoRes.getTotalElements()));
			UserResponse user = new UserResponse(videoRes.getContent(), null, page);
			return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
		} catch (UserException e) {
			e.printStackTrace();
			UserResponse user = new UserResponse(null, e, null);
			return new ResponseEntity<UserResponse>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
