package com.meihua.mapper;

import com.meihua.dto.UserCreateRequest;
import com.meihua.dto.UserDto;
import com.meihua.dto.UserUpdateRequest;
import com.meihua.entity.User;
import com.meihua.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
