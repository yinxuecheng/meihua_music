package com.meihua.dto;

import lombok.Data;

@Data
public class FileUploadDto {

    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String fileKey;

    private String fileId;

    private Long startTime;

    private Long expiredTime;

}
