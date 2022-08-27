package com.meihua.controller;

import com.meihua.mapper.SiteSettingMapper;
import com.meihua.service.SettingService;
import com.meihua.vo.SiteSettingVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
@Api(tags = "配置信息接口")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @Autowired
    private SiteSettingMapper siteSettingMapper;


    @GetMapping("/site")
    @ApiOperation("获取腾讯云存储配置信息")
    public SiteSettingVo getSiteSetting() {
        return siteSettingMapper.toVo(settingService.getSiteSetting());
    }
}
