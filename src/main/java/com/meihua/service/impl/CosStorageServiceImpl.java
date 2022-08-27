package com.meihua.service.impl;

import com.meihua.dto.FileUploadDto;
import com.meihua.exception.BizException;
import com.meihua.exception.ExceptionType;
import com.meihua.service.StorageService;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.TreeMap;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {

    @Value("${cos.bucket}")
    private String bucket;
    @Value("${cos.secret-id}")
    private String secretId;
    @Value("${cos.secret-key}")
    private String secretKey;
    @Value("${cos.region}")
    private String region;

    @Override
    public FileUploadDto initFileUpload() {

        Response response = null;
        try {
            response = CosStsClient.getCredential(getCosStsConfig());
            FileUploadDto fileUploadDto = new FileUploadDto();
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            fileUploadDto.setStartTime(response.startTime);
            fileUploadDto.setExpiredTime(response.expiredTime);
            return fileUploadDto;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BizException(ExceptionType.INNER_ERROR);
        }

    }

    private TreeMap<String,Object> getCosStsConfig() {
        TreeMap<String,Object> config = new TreeMap<>();
        config.put("secretId",secretId);
        config.put("secretKey",secretKey);

        //临时密匙有效时长，单位是秒
        config.put("durationSeconds",1800);
        //权限
        config.put("allowPrefixes",new String[]{
                "*"
        });

        config.put("bucket",bucket);
        config.put("region",region);
        String[] allowActions = new String[]{
                //简单上传
                "name/cos:PutObject",
                "name/cos:PostObject",
                //分片上传
                "name/cos:InitiateMultipartUpload",
                "name/cos:ListMultipartUploads",
                "name/cos:ListParts",
                "name/cos:UploadPart",
                "name/cos:CompleteMultipartUpload",
        };
        config.put("allowActions",allowActions);
        return config;
    }
}
