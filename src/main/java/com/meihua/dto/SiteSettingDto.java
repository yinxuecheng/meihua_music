package com.meihua.dto;

import com.meihua.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
