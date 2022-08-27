package com.meihua.service.impl;

import com.meihua.dto.SiteSettingDto;
import com.meihua.service.FileService;
import com.meihua.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {
    @Value("${cos.bucket}")
    private String bucket;
    @Value("${cos.region}")
    private String region;

    @Autowired
    private FileService fileService;

    @Override
    public SiteSettingDto getSiteSetting() {
        SiteSettingDto siteSettingDto = new SiteSettingDto();
        siteSettingDto.setBucket(bucket);
        siteSettingDto.setRegion(region);
        siteSettingDto.setStorage(fileService.getDefaultStorage());
        return siteSettingDto;
    }
}
