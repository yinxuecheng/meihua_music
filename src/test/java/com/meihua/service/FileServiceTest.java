package com.meihua.service;

import com.meihua.dto.FileDto;
import com.meihua.dto.FileUploadDto;
import com.meihua.dto.FileUploadRequest;
import com.meihua.enums.FileStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    void initUpload() throws IOException {
        FileUploadRequest request = new FileUploadRequest();
        request.setName("测试文件名");
        request.setExt("mp3");
        request.setFileKey("2Cq8R20ej6g2t1BpqsjSDwuJw5M");
        request.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(request);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileKey(),request.getFileKey());
    }

    @Test
    void finishUpload() throws IOException {
        FileUploadRequest request = new FileUploadRequest();
        request.setName("测试文件名");
        request.setExt("mp3");
        request.setFileKey("2Cq8R20ej6g2t1BpqsjSDwuJw5M");
        request.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(request);
        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(),finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED,finishedFile.getStatus());
    }
}