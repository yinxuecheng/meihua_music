package com.meihua.service;

import com.meihua.dto.TokenCreateRequest;
import com.meihua.dto.UserCreateRequest;
import com.meihua.dto.UserDto;
import com.meihua.dto.UserUpdateRequest;
import com.meihua.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto getUser(String id);

    UserDto updateUser(String id, UserUpdateRequest userUpdateRequest);

    void deleteUser(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
