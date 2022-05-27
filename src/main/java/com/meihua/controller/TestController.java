package com.meihua.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/getTest")
    public String getTest(){
        return "欢迎来到梅花音乐App";
    }

}
