package com.demo.web.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.web.rest.resource.UserResource;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RefreshScope
@RestController
@RequestMapping("demoservice/v1/users")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value(value = "${message:World!}")
	private String message;

	@Value(value = "${username:superUser}")
	private String defaultUsername;

	@RequestMapping(method = RequestMethod.GET, value = "/{userName}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Look up for a user")
	public ResponseEntity<UserResource> getUser(
			@ApiParam(value = "User Id", required = true) @PathVariable("userName") String userName) {

		UserResource user = new UserResource();
		user.setMessage("Hello " + userName + " " + message + " from " + defaultUsername);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
