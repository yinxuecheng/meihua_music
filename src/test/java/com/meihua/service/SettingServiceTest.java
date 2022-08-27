package com.meihua.service;

import com.meihua.dto.SiteSettingDto;
import com.meihua.enums.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SettingServiceTest {

    @Autowired
    private SettingService service;

    @Test
    void getSiteSetting() {
        SiteSettingDto siteSetting = service.getSiteSetting();
        Assertions.assertNotNull(siteSetting.getBucket());
        Assertions.assertNotNull(siteSetting.getRegion());
        Assertions.assertEquals(Storage.COS,siteSetting.getStorage());
    }
}