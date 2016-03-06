package com.teleportcall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teleportcall.dto.WebUserSignUpDto;
import com.teleportcall.model.WebUserSignup;
import com.teleportcall.service.WebUserSignUpService;
import com.teleportcall.util.Pagination;
import com.teleportcall.util.UserException;
import com.teleportcall.util.UserResponse;

@Controller
@RequestMapping("/web")
public class WebController {

	@Autowired private WebUserSignUpService service;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity<UserResponse> upsert(@RequestBody WebUserSignUpDto dto) {
		try {
			dto = service.upsert(dto);
			return new ResponseEntity<>(new UserResponse(dto, null, null), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/fetchAll")
	public ResponseEntity<UserResponse> fetchAll(@RequestParam(value="pageNo", defaultValue="0")Integer pageNo,
			@RequestParam(value="pageSize", defaultValue="10")Integer pageSize) {
		try {
			Page<WebUserSignup> res = service.fetchAll(pageNo, pageSize);
			Pagination page = new Pagination();
			page.setIsList(true);
			page.setTotalElements(page.getTotalElements());
			page.setTotalPages(page.getTotalPages());
			page.setPageNo(page.getPageNo());
			return new ResponseEntity<>(new UserResponse(res.getContent(), null, page), HttpStatus.OK);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
