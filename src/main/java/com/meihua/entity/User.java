package com.meihua.entity;

import com.meihua.enums.Gender;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class User extends AbstractEntity{

    private String username;

    @Column(unique = true)
    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "roles_id",referencedColumnName = "id"))
    private List<Role> roles;
}
