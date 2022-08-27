package com.meihua.vo;

import com.meihua.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {

    private String bucket;

    private String region;

    private Storage storage;

}
