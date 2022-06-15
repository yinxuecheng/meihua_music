package com.meihua.vo;

import com.meihua.entity.Role;
import com.meihua.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVo {

    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roles;
}
