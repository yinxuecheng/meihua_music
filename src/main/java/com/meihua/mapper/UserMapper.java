package com.meihua.mapper;

import com.meihua.dto.UserDto;
import com.meihua.entity.User;
import com.meihua.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
