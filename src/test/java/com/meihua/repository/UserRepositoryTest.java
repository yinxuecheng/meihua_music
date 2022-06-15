package com.meihua.repository;

import com.meihua.entity.User;
import com.meihua.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername(){
//        User user = new User();
//        user.setUsername("小新");
//        user.setNickname("程序袁小尹");
//        user.setEnabled(true);
//        user.setLocked(false);
//        user.setPassword("2234");
//        user.setGender(Gender.MALE);
//        user.setLastLoginIp("127.0.0.1");
//        user.setLastLoginTime(new Date());
//        User save = userRepository.save(user);
//        System.out.println(save.toString());
        User aaa = userRepository.getByUsername("小新");
        System.out.println(aaa.toString());
    }
}