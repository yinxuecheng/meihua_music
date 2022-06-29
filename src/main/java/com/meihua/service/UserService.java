package com.meihua.service;

import com.meihua.dto.UserCreateDto;
import com.meihua.dto.UserDto;
import com.meihua.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
