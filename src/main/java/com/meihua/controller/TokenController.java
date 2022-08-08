package com.meihua.controller;

import com.meihua.dto.TokenCreateRequest;
import com.meihua.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
@Api(tags = "token获取")
public class TokenController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation("用户token获取")
    public String create(@RequestBody TokenCreateRequest tokenCreateRequest){
        return userService.createToken(tokenCreateRequest);
    }
}
