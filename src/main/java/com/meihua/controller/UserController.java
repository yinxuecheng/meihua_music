package com.meihua.controller;

import com.meihua.dto.UserCreateRequest;
import com.meihua.dto.UserUpdateRequest;
import com.meihua.mapper.UserMapper;
import com.meihua.service.UserService;
import com.meihua.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    @ApiOperation("用户检索")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<UserVo> search(@PageableDefault(sort = { "createdTime" },
            direction = Sort.Direction.ASC) Pageable pageable){
        return userService.search(pageable).map(userMapper::toVo);
    }

    @PostMapping
    @ApiOperation("用户创建")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest){
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    @ApiOperation("用户信息")
    UserVo getUser(@PathVariable String id) {
        return userMapper.toVo(userService.getUser(id));
    }

    @PutMapping("/{id}")
    @ApiOperation("用户更改")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    UserVo updateUser(@PathVariable String id, @Validated
                      @RequestBody UserUpdateRequest userUpdateRequest){
        return userMapper.toVo(userService.updateUser(id,userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("用户删除")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @GetMapping("/me")
    @ApiOperation("获取当前登录的用户信息")
    UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
    }
}
