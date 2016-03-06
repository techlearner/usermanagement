package com.teleportcall.controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teleportcall.model.GcmNotificationType;
import com.teleportcall.notification.GCMPush;
import com.teleportcall.util.UserException;
import com.teleportcall.util.UserResponse;

@Controller
@RequestMapping("/gcmpush")
public class NotificationController {

	@Autowired private GCMPush gcmPush;
	
	@Value("${gcm.apikey}")
	private String apiKey;
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
	
	@RequestMapping(value="/send/{type}", method = RequestMethod.POST)
	public ResponseEntity<UserResponse> sendPush(@RequestBody GCMDto map,
			@PathVariable("type")String type) {
		
		try {
			Boolean response = gcmPush.pushToGcm(map, GcmNotificationType.valueOf(type), apiKey);
			return new ResponseEntity<UserResponse>(new UserResponse(response, null, null), HttpStatus.OK);
		} catch (UserException e) {
			e.printStackTrace();
			logger.info("PUSH Notification failedd :"+e.getDetailMessage());
			return new ResponseEntity<UserResponse>(new UserResponse(null, e, null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
