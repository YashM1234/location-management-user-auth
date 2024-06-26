package com.application.userauth.controller;

import com.application.userauth.exception.BusinessException;
import com.application.userauth.model.UserModel;
import com.application.userauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/users/login")
    public ResponseEntity<Boolean> login(@RequestBody UserModel userModel) throws BusinessException {

        logger.debug("Entering Method Login");
        boolean result = userService.login(userModel);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
        logger.debug("Exiting Method Login");
        return responseEntity;
    }

    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody UserModel userModel) throws BusinessException {

        Long result = userService.register(userModel);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
